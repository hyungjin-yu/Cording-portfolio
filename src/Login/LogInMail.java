package Login;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class LogInMail {	 // 네이버메일 기준입니다
	
	/*메일을 보내기전 네이버에서 설정을 변경해야 합니다. 로그인할때 2단계인증을 사용중이라면 2단계인증은 꺼주세요. 
	 * (아이디, 비번으로 바로 로그인되어야함)
	 * 네이버메일 => 내 메일함 환경설정 => POP/IMAP 설정 => IMAP/SMTP 설정 => 사용함으로 변경 후 저장*/
	
	public static boolean sendMail(String mail, String id, String password) {
		boolean check = false;
		String str = String.format
				("<html>안녕하세요, 알바헤븐입니다.<br> %s님의 비밀번호를 안내드립니다.<br><br> password : %s <br><br>이용해 주셔서 감사합니다.</html>", 
						id, password);
		
		Properties p = System.getProperties();
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.host", "smtp.naver.com");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.port", "587");

		Authenticator auth = new MyAuthentication();
		Session session = Session.getDefaultInstance(p);
		MimeMessage msg = new MimeMessage(session);

		try {
			msg.setSentDate(new Date());
			InternetAddress from = new InternetAddress();

			from = new InternetAddress("ALBAheaven<관리자메일아이디@naver.com>"); 	//하부클래스에 입력한 아이디
			msg.setFrom(from);

			InternetAddress to = new InternetAddress(mail);	 //비밀번호를 찾아야하는 사람의 메일주소 자동셋팅
			msg.setRecipient(Message.RecipientType.TO, to);
			
			msg.setSubject("비밀번호를 잊어버리셨나요?", "UTF-8");
			msg.setText(str, "UTF-8");
			msg.setHeader("content-Type", "text/html");

			javax.mail.Transport.send(msg);	
			check = true;
		} catch (AddressException addr_e) {
			addr_e.printStackTrace();
		} catch (MessagingException msg_e) {
			msg_e.printStackTrace();
		}
		
		return check;
	}
}

class MyAuthentication extends Authenticator {

	PasswordAuthentication account;

	public MyAuthentication() {
		String Id = "1234";  //테스트를 위해 실제사용하는 아이디를 넣어주세요
		char[] pw = {1234};  //테스트를 위해 해당아이디의 비밀번호를 넣어주세요
		account = new PasswordAuthentication(Id, pw);
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return account;
	}
}
