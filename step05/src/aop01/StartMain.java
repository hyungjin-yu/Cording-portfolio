package aop01;

public class StartMain {
	public static void main(String[] args) {
		Woman w = new Woman();
		System.out.println("*** 여학생 입장 ***");
		w.classWork();
		System.out.println("--------------------");
		
		Main m = new Main();
		System.out.println("*** 남학생 입장 ***");
		m.classWork();
		System.out.println("--------------------");
	}
}
