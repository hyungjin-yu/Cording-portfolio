package sample6;

import java.io.IOException;

public class MessageBeanImpl implements MessageBean{
	private String name;
	private String phone;
	private Outputter outputter;
	
	public MessageBeanImpl(String name) {
		this.name = name;
		System.out.println("3. Bean 객체 생성");
	}
	
	@Override
	public void helloCall() {
		String message = name + " : " + phone;
		System.out.println(message);
		
		try {
			outputter.output(message);	// 파일로 메세지 저장
			System.out.println("7. 작업 끝");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println("4. phone을 입력받음");
	}

	public Outputter getOutputter() {
		return outputter;
	}

	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
		System.out.println("5. outputter을 입력받음");
	}
}
