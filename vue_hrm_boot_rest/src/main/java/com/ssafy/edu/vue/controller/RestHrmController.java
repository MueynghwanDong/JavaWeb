package com.ssafy.edu.vue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.edu.vue.dto.DepCountDto;
import com.ssafy.edu.vue.dto.DepartmentDto;
import com.ssafy.edu.vue.dto.DepartmentEmpDto;
import com.ssafy.edu.vue.dto.EmployeeDto;
import com.ssafy.edu.vue.help.BoolResult;
import com.ssafy.edu.vue.help.NumberResult;
import com.ssafy.edu.vue.service.EmployeeService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@RequestMapping("/api")
@Slf4j // lombok
public class RestHrmController {

	@Autowired
	EmployeeService service;

	@GetMapping("/findAllEmployees")
	@ApiOperation(value = "전체 사원의 정보를 반환한다.", response = List.class)
	public ResponseEntity<Object> findAllEmployees() {
		log.trace("findAllEmployees");
		try {
			List<EmployeeDto> emps = service.findAllEmployees();
			return new ResponseEntity<Object>(emps, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("findAllEmployees", e);
			throw e; //

		}
	}

	@GetMapping("/getEmployeesTotal")
	@ApiOperation(value = "전체 사원 수를 반환한다.", response = Integer.class)
	public ResponseEntity<Object> getEmployeesTotal() {
		log.trace("getEmployeesTotal");
		try {
			int result = service.getEmployeesTotal();
			NumberResult nr = null;
			if (result > 0) {
				nr = new NumberResult("getEmployeesTotal", result, "SUCCESS");
			} else {
				nr = new NumberResult("getEmployeesTotal", result, "FAIL");
			}
			return new ResponseEntity<Object>(nr, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("getEmployeesTotal", e);
			throw e; //
		}

	}

	@GetMapping("/findLikeEmployees/{name}")
	@ApiOperation(value = "like 검색을 통한 사원 반환.", response = String.class)
	public ResponseEntity<Object> findLikeEmployees(@PathVariable String name) {
		log.trace("findLikeEmployees");
		try {
			// name = '%'+name+'%';
			List<EmployeeDto> emps = service.findLikeEmployees(name);
			return new ResponseEntity<Object>(emps, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("findLikeEmployees", e);
			throw e; //
		}

	}

	@GetMapping("/findEmployeeById/{id}")
	@ApiOperation(value = "id 검색에 따른 사원 반환", response = Integer.class)
	public ResponseEntity<Object> findEmployeeById(@PathVariable int id) {
		log.trace("findEmployeeById");
		try {
			EmployeeDto emp = service.findEmployeeById(id);
			return new ResponseEntity<Object>(emp, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("findEmployeeById", e);
			throw e; //
		}

	}

	@GetMapping("/findAllTitles")
	@ApiOperation(value = "모든 title 반환")
	public ResponseEntity<Object> findAllTitles() {
		log.trace("findAllTitles");
		try {
			List<EmployeeDto> emps = service.findAllTitles();
			return new ResponseEntity<Object>(emps, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("findAllTitles", e);
			throw e; //
		}

	}

	@GetMapping("/findAllDepartments")
	@ApiOperation(value = "모든 부서 정보 반환")
	public ResponseEntity<Object> findAllDepartments() {
		log.trace("findAllDepartments");
		try {
			List<DepartmentDto> depts = service.findAllDepartments();
			return new ResponseEntity<Object>(depts, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("findAllDepartments", e);
			throw e; //
		}

	}

	@GetMapping("/findEmployeesByManagerId/{managerId}")
	@ApiOperation(value = "managerid에 따른 정보 반환", response = Integer.class)
	public ResponseEntity<Object> findEmployeesByManagerId(@PathVariable int managerId) {
		log.trace("findEmployeesByManagerId");
		try {
			List<EmployeeDto> emps = service.findEmployeesByManagerId(managerId);
			return new ResponseEntity<Object>(emps, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("findEmployeesByManagerId", e);
			throw e; //
		}

	}

	@PostMapping("/addEmployee")
	@ApiOperation(value = "정보 추가")
	public ResponseEntity<Object> addEmployee(@RequestBody EmployeeDto emp) {
		log.trace("addEmployee: {} ", emp);
		try {
			boolean c = service.addEmployee(emp);
			BoolResult br = null;
			if (c) {
				br = new BoolResult("addEmployee", c, "SUCCESS");
			} else {
				br = new BoolResult("addEmployee", c, "FAIL");
			}
			return new ResponseEntity<Object>(br, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("addEmployee", e);
			throw e; //
		}

	}

	@DeleteMapping("/deleteEmployee/{id}")
	@ApiOperation(value = "정보 삭제", response = Integer.class)
	public ResponseEntity<Object> deleteEmployee(@PathVariable int id) {
		log.trace("deleteEmployee");
		try {
			boolean c = service.deleteEmployee(id);
			BoolResult br = null;
			if (c) {
				br = new BoolResult("deleteEmployee", c, "SUCCESS");
			} else {
				br = new BoolResult("deleteEmployee", c, "FAIL");
			}
			return new ResponseEntity<Object>(br, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("deleteEmployee", e);
			throw e; //
		}
	}

	@PutMapping("/updateEmployee")
	@ApiOperation(value = "정보 수정")
	public ResponseEntity<Object> updateEmployee(@RequestBody EmployeeDto emp) {
		log.trace("updateEmployee");
		try {
			boolean c = service.updateEmployee(emp);
			BoolResult br = null;
			if (c) {
				br = new BoolResult("updateEmployee", c, "SUCCESS");
			} else {
				br = new BoolResult("updateEmployee", c, "FAIL");
			}
			return new ResponseEntity<Object>(br, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("updateEmployee", e);
			throw e; //
		}
	}

	@GetMapping("/findDepartmentsBydeptid/{deptid}")
	@ApiOperation(value = "dept_id에 따른 정보 반환", response = Integer.class)
	public ResponseEntity<Object> findDepartmentsBydeptid(@PathVariable int deptid) {
		log.trace("findDepartmentsBydeptid");
		try {
			List<EmployeeDto> emps = service.findDepartmentsBydeptid(deptid);
			return new ResponseEntity<Object>(emps, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("findDepartmentsBydeptid", e);
			throw e; //
		}

	}

	@GetMapping("/findDepartmentsByname/{name}")
	@ApiOperation(value = "dept_name에 따른 정보 반환", response = String.class)
	public ResponseEntity<Object> findDepartmentsByname(@PathVariable String name) {
		log.trace("findDepartmentsByname");
		try {
			List<EmployeeDto> emps = service.findDepartmentsByname(name);
			return new ResponseEntity<Object>(emps, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("findDepartmentsByname", e);
			throw e; //
		}

	}
	
	@GetMapping("/findDepartmentsByname2/{name}")
	@ApiOperation(value = "dept_name2에 따른 정보 반환", response = String.class)
	public ResponseEntity<Object> findDepartmentsByname2(@PathVariable String name) {
		log.trace("findDepartmentsByname2");
		try {
			List<EmployeeDto> emps = service.findDepartmentsByname2(name);
			return new ResponseEntity<Object>(emps, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("findDepartmentsByname2", e);
			throw e; //
		}

	}

	@GetMapping("/findAllDeptEmps")
	@ApiOperation(value = "직원과 부서에 따른 정보 반환")
	public ResponseEntity<Object> findAllDeptEmps() {
		log.trace("findAllDeptEmps");
		try {
			List<DepartmentEmpDto> ed = service.findAllDeptEmps();
			return new ResponseEntity<Object>(ed, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("findAllDeptEmps", e);
			throw e; //
		}

	}

	@GetMapping("/findAllDepCounts")
	@ApiOperation(value = " DepCountDto의 목록 형태 정보 반환")
	public ResponseEntity<Object> findAllDepCounts() {
		log.trace("findAllDepCounts");
		try {
			List<DepCountDto> ec = service.findAllDepCounts();
			return new ResponseEntity<Object>(ec, HttpStatus.OK);
		} catch (RuntimeException e) {
			log.error("findAllDepCounts", e);
			throw e; //
		}

	}

}
