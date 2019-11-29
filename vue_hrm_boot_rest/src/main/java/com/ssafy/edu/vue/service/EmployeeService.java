package com.ssafy.edu.vue.service;

import java.util.List;

import com.ssafy.edu.vue.dto.DepCountDto;
import com.ssafy.edu.vue.dto.DepartmentDto;
import com.ssafy.edu.vue.dto.DepartmentEmpDto;
import com.ssafy.edu.vue.dto.EmployeeDto;

public interface EmployeeService {

	public List<EmployeeDto> findAllEmployees();//

	public EmployeeDto findEmployeeById(int id);//

	public int getEmployeesTotal();//

	public List<EmployeeDto> findLikeEmployees(String name);//

	public List<DepartmentDto> findAllDepartments();//
	

	public List<EmployeeDto> findAllTitles();//

	public boolean addEmployee(EmployeeDto emp);///

	public boolean updateEmployee(EmployeeDto emp);//

	public boolean deleteEmployee(int id);//


    public List<EmployeeDto> findEmployeesByManagerId(int managerId);//
    

    public List<EmployeeDto> findDepartmentsBydeptid(int dept_id);

    public List<EmployeeDto> findDepartmentsByname(String name);
    public List<EmployeeDto> findDepartmentsByname2(String name);

    public List<DepCountDto> findAllDepCounts();

    public List<DepartmentEmpDto> findAllDeptEmps();
}