package aop08;

public class CoreEx {
	public void zeroMethod(int a, int b) {
		try {
			System.out.println(a + " / " + b + " = " + (a/b));
		} catch(Exception e) {
			throw new RuntimeException("0으로 나눌 수 없습니다.");	// 예외를 발생시켜서 던져버림
		} 
	}
}
