package org.zerock.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.MemberVO;
import org.zerock.persistence.MemberDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
public class MemberDAOTest {

	@Autowired
	private MemberDao dao;

	@Test
	public void test() {
		System.out.println(dao.getTime());
	}

	@Test
	public void testcase() {
		MemberVO vo = new MemberVO();
		vo.setUserid("user00");
		vo.setUserpw("user00");
		vo.setUsername("user00");
		vo.setEmail("user00@aaa.com");
		dao.insertMember(vo);
	}

}
