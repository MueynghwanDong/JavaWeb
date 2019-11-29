package com.ssafy.edu.vue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.vue.dao.EmployeeDAO;
import com.ssafy.edu.vue.dto.DepCountDto;
import com.ssafy.edu.vue.dto.DepartmentDto;
import com.ssafy.edu.vue.dto.DepartmentEmpDto;
import com.ssafy.edu.vue.dto.EmployeeDto;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO dao;

	@Override
	public List<EmployeeDto> findAllEmployees() {
		return dao.findAllEmployees();
	}

	@Override
	public EmployeeDto findEmployeeById(int id) {
		return dao.findEmployeeById(id);
	}

	@Override
	public int getEmployeesTotal() {
		return dao.getEmployeesTotal();
	}

	@Override
	public List<EmployeeDto> findLikeEmployees(String name) {
		return dao.findLikeEmployees(name);
	}

	@Override
	public List<DepartmentDto> findAllDepartments() {
		return dao.findAllDepartments();
	}

	@Override
	public List<EmployeeDto> findAllTitles() {
		return dao.findAllTitles();
	}

	@Override
	@Transactional
	public boolean addEmployee(EmployeeDto emp) {
		return dao.addEmployee(emp);
	}

	@Override
	public boolean updateEmployee(EmployeeDto emp) {
		return dao.updateEmployee(emp);
	}

	@Override
	public boolean deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}

	@Override
	public List<DepartmentEmpDto> findAllDeptEmps() {
		return dao.findAllDeptEmps();
	}

	@Override
	public List<DepCountDto> findAllDepCounts() {
		return dao.findAllDepCounts();
	}

	@Override
	public List<EmployeeDto> findDepartmentsBydeptid(int deptid) {
		return dao.findDepartmentsBydeptid(deptid);
	}

	@Override
	public List<EmployeeDto> findDepartmentsByname(String name) {
		return dao.findDepartmentsByname(name);
	}

	@Override
	public List<EmployeeDto> findEmployeesByManagerId(int managerId) {
		return dao.findEmployeesByManagerId(managerId);
	}

	@Override
	public List<EmployeeDto> findDepartmentsByname2(String name) {
		return dao.findDepartmentsByname2(name);
	}

}
