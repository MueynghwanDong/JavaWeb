package controls;

import java.util.HashMap;
import java.util.Map;

import annotation.Component;
import dao.MemberDao;

// Annotation 적용
@Component("/member/list.do")
public class MemberListController implements Controller {
	MemberDao memberDao;

	public MemberListController setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}

	// 정렬 조건을 알아야하고 페이지컨트롤러는 databinding 인터페이스를 구현해야함
	// 받기원하는 매개변수 이름과 데이터 형 선언
	public Object[] getDataBinders() {
		return new Object[] { "orderCond", String.class };
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HashMap<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("orderCond", model.get("orderCond")); // 매개변수로 전달할 객체 준비
		model.put("members", memberDao.selectList(paramMap));
		return "/member/MemberList.jsp";
	}
}
