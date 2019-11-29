package com.ssafy.edu.vue.dao;

import java.util.List;

import com.ssafy.edu.vue.dto.DepCountDto;
import com.ssafy.edu.vue.dto.DepartmentDto;
import com.ssafy.edu.vue.dto.DepartmentEmpDto;
import com.ssafy.edu.vue.dto.EmployeeDto;

public interface EmployeeDAO {
	/**
	 * 모든 Employee 목록을 조회 후 리턴한다.
	 * 
	 * @return
	 */
	List<EmployeeDto> findAllEmployees();

	/**
	 * 전체 Employee의 수를 리턴한다.
	 * 
	 * @return
	 */
	int getEmployeesTotal();

	/**
	 * employee를 이름 기반으로 like 검색 후 리스트를 반환한다.
	 * 
	 * @param name
	 * @return
	 */
	List<EmployeeDto> findLikeEmployees(String name);

	/**
	 * 모든 department 정보를 리턴한다.
	 * 
	 * @return
	 */
	List<DepartmentDto> findAllDepartments();

	/**
	 * 모든 직무(title)정보를 리턴한다.
	 * 
	 * @return
	 */
	List<EmployeeDto> findAllTitles();

	/**
	 * id 기반으로 employee를 조회후 리턴한다.
	 * 
	 * @param id
	 * @return
	 */
	EmployeeDto findEmployeeById(int id);

	/**
	 * managerId에 해당하는 manager를 가지는 직원의 목록을 반환한다.
	 * 
	 * @param managerId
	 * @return
	 * @throws Exception
	 */
	public List<EmployeeDto> findEmployeesByManagerId(int managerId);

	/**
	 * deptId에 속한 직원들의 목록을 반환한다.
	 * 
	 * @param dept_id
	 * @return
	 * @throws Exception
	 */
	public List<EmployeeDto> findDepartmentsBydeptid(int dept_id);

	/**
	 * 직원명으로 like 검색해서 그 직원들과 같은 부서에 근무하는 직원의 목록을 반환하시오.
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<EmployeeDto> findDepartmentsByname(String name);
	public List<EmployeeDto> findDepartmentsByname2(String name);
	/**
	 * 모든 부서에 대해 부서별 코드, 이름과 함께 직원수를 DepCountDto의 목록 형태로 반환한다.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<DepCountDto> findAllDepCounts();

	/**
	 * 직원의 정보와 함께 부서 정보를 DepartmentEmpDto의 목록 형태로 반환하시오.
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<DepartmentEmpDto> findAllDeptEmps();

	/**
	 * employee 정보를 저장한 후 결과가 0보다 큰지 리턴한다.
	 * 
	 * @param emp
	 * @return
	 */
	boolean addEmployee(EmployeeDto emp);

	/**
	 * employee 정보를 수정한 후 결과가 0보다 큰지 리턴한다.
	 * 
	 * @param emp
	 * @return
	 */
	boolean updateEmployee(EmployeeDto emp);

	/**
	 * id에 해당하는 사용자 정보를 삭제한 후 결과가 0보다 큰지 리턴한다.
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteEmployee(int id);

}