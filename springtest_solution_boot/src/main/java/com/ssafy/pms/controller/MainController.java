package com.ssafy.pms.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.pms.Phone;
import com.ssafy.pms.UserInfo;
import com.ssafy.pms.service.IPhonService;

@Controller
public class MainController implements ErrorController{

	private static Logger logger = LoggerFactory.getLogger(MainController.class);
	@Autowired
	IPhonService pservice;
	// IPS를 참조하는 PROXY가 생기고 그것이 동작 (대부분의 동작을 담당한다)
	// PROXY가 트랜잭션 처리하는 것을 담당
	// PSI는 비즈니스로직만 담당 ...

	@GetMapping("rest.do")
	public String getrestForm() {
		
		return "restclient";
	}

	@GetMapping("login.do")
	public String getLoginForm() {
		return "Login";
	}

	@PostMapping("login.do")
	public String doLogin(UserInfo user, HttpSession session, Model model) {
		try {
			UserInfo selected = pservice.selectUser(user);
			if (selected != null) {
				session.setAttribute("loginUser", selected);
				return "pms/PhoneReg";
			} else {
				return "Login";
			}
		} catch (RuntimeException e) {
			model.addAttribute("title", "로그인 오류");
			model.addAttribute("message", "문제 내용 - 로그인 과정에서 오류");
			return "Error";
		}
	}

	@GetMapping("logout.do")
	public String getLogout(HttpSession session) {
		session.invalidate();
		return "Login";
	}

	@GetMapping("regPhone.do")
	public String getReg() {
		return "pms/PhoneReg";
	}

	@GetMapping("searchPhone.do")
	public String getList(Model model) {
		try {
			List<Phone> list = pservice.select();
			model.addAttribute("title", "핸드폰 관리-목록 조회");
			model.addAttribute("phones", list);
			return "pms/PhoneList";
		} catch (RuntimeException e) {
			logger.trace("조회 실패", e);
			model.addAttribute("title", "핸드폰 관리 - 조회 실패");
			model.addAttribute("message", "문제 내용 - 조회중 오류 발생");
			return "Error";
		}
	}

	@GetMapping("view.do")
	public String getDetail(Phone p, Model model) {
		try {
			Phone phone = pservice.select(p);
			model.addAttribute("phone", phone);
			model.addAttribute("title", "핸드폰 관리-상세 조회");
			return "pms/PhoneView";
		} catch (RuntimeException e) {
			logger.trace("조회 실패", e);
			model.addAttribute("title", "핸드폰 관리 - 조회 실패");
			model.addAttribute("message", "문제 내용 - 조회중 오류 발생");
			return "Error";
		}
	}

	@PostMapping("savePhone.do")
	public String doSave(Phone phone, Model model) {
		try {
			int result = pservice.insert(phone);
			model.addAttribute("title", "핸드폰 관리-등록 성공");
			return "pms/result";
		} catch (RuntimeException e) {
			logger.trace("저장실패", e);
			model.addAttribute("title", "핸드폰 관리 - 등록 실패");
			model.addAttribute("message", "문제 내용 - 저장중 오류 발생");
			return "Error";
		}
	}

	@GetMapping("delPhone.do")
	public String doDelete(@RequestParam List<String> num, Model model) {
		try {
			int result = pservice.delete(num);
			return "redirect:searchPhone.do";

		} catch (RuntimeException e) {
			logger.trace("삭제실패", e);
			model.addAttribute("title", "핸드폰 관리 - 삭제 실패");
			model.addAttribute("message", "문제 내용 - 삭제중 오류 발생");
			return "Error";
		}

	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/error")
	public String handleError(HttpServletRequest req, Model model) {
		Object status = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status!=null) {
			Integer code = Integer.parseInt(status.toString());
			if(code==404) {
				model.addAttribute("message","찾는 페이지가 없습니다.");
			}else {
				model.addAttribute("message","잠시 후 다시 시도해주세요.");
			}
		}
		return "Error";
		
	}
	
	
}
