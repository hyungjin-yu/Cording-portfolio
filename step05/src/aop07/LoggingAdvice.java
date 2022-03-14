package aop07;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAdvice {
	// Throwable : Exception의 부모 클래스
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		// 가로채온 함수 이름 얻어오기
		String methodName = joinPoint.getSignature().getName();
		
		// 시간을 재는 클래스
		StopWatch sw = new StopWatch();
		
		// 공통 관심 사항 : Before
		System.out.println("[LOG] METHOD : " + methodName + "is Calling");
		sw.start();
		
		joinPoint.proceed();	// 핵심 관심 사항 동작
		
		// 공통 관심 사항 : After
		sw.stop();
		System.out.println("[LOG] METHOD : " + methodName + "was done.");
		System.out.println("[LOG] 처리 시간 : " + sw.getTotalTimeMillis() + "ms");
	}
}	
