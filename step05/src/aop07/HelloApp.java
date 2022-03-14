package aop07;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {	
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("aop07/bean.xml");
		
		MessageBean messageBean = (MessageBean) context.getBean("messageBean");
		messageBean.sayHello();
		
		context.close();
	}
}
