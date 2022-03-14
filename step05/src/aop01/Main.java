package aop01;

public class Main {
	public void classWork() {
		System.out.println("교실 문을 연다.");
		
		try {
			System.out.println("컴퓨터를 켜고 Game을 시작한다.");
		} catch (Exception e) {
			System.out.println("*** 오늘은 소독하는 날 ***");
		} finally {
			System.out.println("전등이 켜져있는 지 확인한다.");
		}
		System.out.println("교실 문을 잠근다.");
	}
}
