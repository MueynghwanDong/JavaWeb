package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice // 컨트롤러에서 발생하는 예외에 대해 전문적으로 처리하는 클래스라는 것을 명시
public class CommonExceptionAdvice {

	private static final Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);

	@ExceptionHandler(Exception.class)
	private ModelAndView errorModelAndView(Exception e) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/error_common");
		modelAndView.addObject("exception", e);
		return modelAndView;
	}
}
