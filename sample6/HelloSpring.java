package sample6;

import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {
	public static void main(String[] args) {
		System.out.println("** Start **");
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("sample6/bean.xml");
		System.out.println("** End **");
		
		MessageBean bean = (MessageBean) context.getBean("messageBean");
		bean.helloCall();
		System.out.println("--------------------------");
		
		context.close();
	}
}
