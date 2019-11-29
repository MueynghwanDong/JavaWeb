package controls;

import java.util.Map;

import annotation.Component;
import bind.DataBinding;
import dao.MemberDao;
import dao.ProjectDao;
import vo.Member;
import vo.Project;

@Component("/project/update.do")
public class ProjectUpdateController implements Controller, DataBinding {

	ProjectDao projectDao;

	public ProjectUpdateController setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Project project = (Project) model.get("project");
		if (project.getTitle() == null) {
			Integer no = (Integer) model.get("no");
			Project detailInfo = projectDao.selectOne(no);
			model.put("project", detailInfo);
			return "/project/ProjectUpdateForm.jsp";

		} else {

			projectDao.update(project);
			return "redirect:list.do";
		}
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "no", Integer.class, "project", vo.Project.class };
	}
}
