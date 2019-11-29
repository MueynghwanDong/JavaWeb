package controls;

import java.util.Map;

import annotation.Component;
import bind.DataBinding;
import dao.MemberDao;
import dao.ProjectDao;

@Component("/project/delete.do")
public class ProjectDeleteController implements Controller, DataBinding {

	ProjectDao projectDao;

	public ProjectDeleteController seProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Integer no = (Integer) model.get("no");
		projectDao.delete(no);
		return "redirect:list.do";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[] { "no", Integer.class };
	}
}
