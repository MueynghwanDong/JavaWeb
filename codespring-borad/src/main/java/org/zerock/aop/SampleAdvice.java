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

@Component // �������� ������ �νĵǱ� ���� ����
@Aspect // aop����� �ϴ� Ŭ������ ���� �߰�
public class SampleAdvice {
	
	private static final Logger logger= LoggerFactory.getLogger(SampleAdvice.class);
	
	@Before("execution(* org.zerock.service.MessageService*.*(..))") // �ش� �޼ҵ� ���� ������ target �޼ҵ尡 ����ǰ� �ϴ� ��
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
