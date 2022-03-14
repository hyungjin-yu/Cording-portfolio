package aop03;

public class Man implements Person{
	public void classWork() {
		MyAspect aspect = new MyAspect();
		
		
		System.out.println("컴퓨터를 켜고 Game을 시작한다.");
		
	}
}
