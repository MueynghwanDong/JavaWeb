package com.ssafy.pms.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.ssafy.pms.Phone;
import com.ssafy.pms.service.IPhonService;

@RestController // 응답: json
@RequestMapping("/pms/rest")
@CrossOrigin(value = "*")
public class PhoneRestController {

	private static Logger logger = LoggerFactory.getLogger(PhoneRestController.class);

	@Autowired
	IPhonService service;

	@PostMapping("/phone")
	public ResponseEntity<Map<String, Object>> insert(@RequestBody Phone phone) {
		try {
			int result = service.restInsert(phone);
			return response(result, HttpStatus.CREATED, true);
		} catch (RuntimeException e) {
			logger.error("추가 실패", e);
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}

	@GetMapping("/select/${num}")
	public ResponseEntity<Map<String, Object>> select(@PathVariable String num) {
		try {
			return response(service.restSelect(num), HttpStatus.OK, true);
		} catch (RuntimeException e) {
			logger.error("검색 실패", e);
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}

	@GetMapping("/selectAll")
	public ResponseEntity<Map<String, Object>> selectAll() {
		try {
			return response(service.restSelectAll(), HttpStatus.CREATED, true);
		} catch (RuntimeException e) {
			logger.error("검색 실패", e);
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}

	@DeleteMapping("/delete/${num}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable String num) {
		try {
			int result = service.restDelete(num);
			return response(result, HttpStatus.NO_CONTENT, true);
		} catch (RuntimeException e) {
			logger.error("삭제 실패", e);
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Map<String, Object>> update(@RequestBody Phone phone) {
		try {
			int result = service.restUpdate(phone);
			return response(result, HttpStatus.CREATED, true);
		} catch (RuntimeException e) {
			logger.error("수정 실패", e);
			return response(e.getMessage(), HttpStatus.CONFLICT, false);
		}
	}

	private ResponseEntity<Map<String, Object>> response(Object data, HttpStatus httpstatus, boolean status) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("status", status);
		resultMap.put("data", data);
		// 상태와 함께 Map 반환
		return new ResponseEntity<Map<String, Object>>(resultMap, httpstatus);
	}
}
