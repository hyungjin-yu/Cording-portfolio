package aop06;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Person{
	public void classWork() {
			System.out.println("컴퓨터를 켜고 Shopping을 시작한다.");
	}
}
