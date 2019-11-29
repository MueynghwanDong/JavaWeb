package com.ssafy.safefood;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.safefood.dto.Member;
import com.ssafy.safefood.service.MemberService;

@SpringBootTest
class SpringBootSafeFoodApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(SpringBootSafeFoodApplicationTests.class);
	
	@Autowired
	MemberService service;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void LoginTest() {
		Member result = service.login("ssafy", "1111");
		log.trace("service login func {0}", result);
		assertThat(result).isNotNull();
	}

}
