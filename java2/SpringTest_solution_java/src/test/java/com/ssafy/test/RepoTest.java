package com.ssafy.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.ssafy.pms.Phone;
import com.ssafy.pms.UserInfo;
import com.ssafy.pms.repo.IPhoneDao;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:/spring/application-config.xml")

public class RepoTest {

	@Autowired
	IPhoneDao repo;

	@Test
	public void test() {
		UserInfo user = new UserInfo();
		user.setid("ssafy");
		UserInfo selected = repo.selectUser(user);
		assertThat(selected.getpw(), is("ssafy"));
	}
	
	@Test
	public void testselect() {
		List<Phone> phones = repo.select();
		assertThat(phones.size(), is(10));
		
		Phone phone = repo.select(new Phone("S105G",null,0,null));
		assertThat(phone.getVcode(), is("10"));
		assertThat(phone.getComp().getVendor(), is("삼성"));
	}

}
