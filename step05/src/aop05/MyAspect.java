package aop05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
	// 핵심관심사항 함수 설정
	@Pointcut("execution(* classWork())")
	public void myClass() {}
	
	@Before("myClass()")
	public void before(JoinPoint joinPoint) {
		System.out.println("교실 문을 연다.");
	}
	
	@After("myClass()")
	public void after(JoinPoint joinPoint) {
		System.out.println("교실 문을 잠근다.");
	}
}
