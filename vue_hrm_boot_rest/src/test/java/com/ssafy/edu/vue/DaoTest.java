package com.ssafy.edu.vue;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.EmployeeDAO;
import com.ssafy.edu.vue.dto.EmployeeDto;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional // 롤백 적용
@Slf4j
class DaoTest {

	@Autowired
	EmployeeDAO dao;

	@Test
	void daotest() {
		List<EmployeeDto> list = dao.findAllEmployees();
		assertEquals(list.size(), 25);
	}
	
	@Test
	void insertTest() {
		EmployeeDto emp = new EmployeeDto(null,"홍길동","hong","2019-11-01" ,null, "총무", 110, 100000.0, 10.0);
		boolean result = dao.addEmployee(emp);
		assertThat(result);
		log.trace("직원 번호 : {}",emp.getId());
		assertThat(emp.getId()).isNotNull();
	}

}
