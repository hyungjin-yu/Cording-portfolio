package sample4;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		// 1. 스프링 컨테이너 구동
		// => bean.xml에 설정된 <bean>태그의 정보대로 객체를 생성하고 초기화한다.
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("sample4/bean.xml");
		
		// 2. bean 객체 얻기 
		// => bean.xml의 <bean>태그의 id로 객체를 얻어옴
		MessageBean bean = (MessageBean) context.getBean("messageBean");
		bean.sayHello();
		
		// 3. 스프링 컨테이너 종료
		context.close();
	}
}
