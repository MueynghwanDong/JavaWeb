package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // 스프링의 빈으로 인식되기 위해 설정
@Aspect // aop기능을 하는 클래스의 선언에 추가
public class SampleAdvice {
	
	private static final Logger logger= LoggerFactory.getLogger(SampleAdvice.class);
	
	@Before("execution(* org.zerock.service.MessageService*.*(..))") // 해당 메소드 먼저 실행후 target 메소드가 실행되게 하는 것
	public void startLog(JoinPoint jp) {
		logger.info("--------------------------");
		logger.info("--------------------------");
		logger.info(Arrays.deepToString(jp.getArgs()));
	}
	@Around("execution(* org.zerock.service.MessageService*.*(..))")
	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable{
		long startTime = System.currentTimeMillis();
		logger.info(Arrays.toString(pjp.getArgs()));
		Object result = pjp.proceed();
		long endtime = System.currentTimeMillis();
		logger.info(pjp.getSignature().getName()+ " : " + (endtime - startTime));
		logger.info("================================");
		return result;
	}
}
