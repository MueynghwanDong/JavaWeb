package com.ssafy.edu.vue.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dto.DepCountDto;
import com.ssafy.edu.vue.dto.DepartmentDto;
import com.ssafy.edu.vue.dto.DepartmentEmpDto;
import com.ssafy.edu.vue.dto.EmployeeDto;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	SqlSession session;
	
	private final String ns = "com.ssafy.edu.vue.dao.HrmMapper.";
	
	@Override
	public List<EmployeeDto> findAllEmployees() {
		return session.selectList(ns+"findAllEmployees");
	}

	@Override
	public int getEmployeesTotal() {
		return session.selectOne(ns+"getEmployeesTotal");
	}

	@Override
	public List<EmployeeDto> findLikeEmployees(String name) {
		return session.selectList(ns+"findLikeEmployees",name);
	}

	@Override
	public List<DepartmentDto> findAllDepartments() {
		return session.selectList(ns+"findAllDepartments");
	}

	@Override
	public List<EmployeeDto> findAllTitles() {
		return session.selectList(ns+"findAllTitles");
	}

	@Override
	public EmployeeDto findEmployeeById(int id) {
		return session.selectOne(ns+"findEmployeeById",id);
	}

	@Override
	public boolean addEmployee(EmployeeDto emp) {
		return session.insert(ns+"addEmployee",emp)>0;
	}

	@Override
	public boolean updateEmployee(EmployeeDto emp) {
		return session.update(ns+"updateEmployee",emp)>0;
	}

	@Override
	public boolean deleteEmployee(int id) {
		return session.delete(ns+"deleteEmployee",id)>0;
	}

	@Override
	public List<DepartmentEmpDto> findAllDeptEmps() {
		return session.selectList(ns+"findAllDeptEmps");
	}

	@Override
	public List<DepCountDto> findAllDepCounts() {
		return session.selectList(ns+"findAllDepCounts");
	}

	@Override
	public List<EmployeeDto> findDepartmentsBydeptid(int deptid) {
		return session.selectList(ns+"findDepartmentsBydeptid", deptid);
	}

	@Override
	public List<EmployeeDto> findDepartmentsByname(String name) {
		return session.selectList(ns+"findDepartmentsByname",name);
	}

	@Override
	public List<EmployeeDto> findEmployeesByManagerId(int managerId) {
		return session.selectList(ns+"findEmployeesByManagerId",managerId);
	}

	@Override
	public List<EmployeeDto> findDepartmentsByname2(String name) {
		return session.selectList(ns+"findDepartmentsByname2",name);
	}

}
