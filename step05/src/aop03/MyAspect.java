package aop03;

import org.aspectj.lang.JoinPoint;

public class MyAspect {
	public void before(JoinPoint joinPoint) {
		System.out.println("교실 문을 연다.");
	}
	
	public void after(JoinPoint joinPoint) {
		System.out.println("겨실 문을 닫는다.");
	}
}
