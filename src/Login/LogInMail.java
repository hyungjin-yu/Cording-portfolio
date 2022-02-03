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

public class LogInMail {	 // ���̹����� �����Դϴ�
	
	/*������ �������� ���̹����� ������ �����ؾ� �մϴ�. �α����Ҷ� 2�ܰ������� ������̶�� 2�ܰ������� ���ּ���. 
	 * (���̵�, ������� �ٷ� �α��εǾ����)
	 * ���̹����� => �� ������ ȯ�漳�� => POP/IMAP ���� => IMAP/SMTP ���� => ��������� ���� �� ����*/
	
	public static boolean sendMail(String mail, String id, String password) {
		boolean check = false;
		String str = String.format
				("<html>�ȳ��ϼ���, �˹�����Դϴ�.<br> %s���� ��й�ȣ�� �ȳ��帳�ϴ�.<br><br> password : %s <br><br>�̿��� �ּż� �����մϴ�.</html>", 
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

			from = new InternetAddress("ALBAheaven<�����ڸ��Ͼ��̵�@naver.com>"); 	//�Ϻ�Ŭ������ �Է��� ���̵�
			msg.setFrom(from);

			InternetAddress to = new InternetAddress(mail);	 //��й�ȣ�� ã�ƾ��ϴ� ����� �����ּ� �ڵ�����
			msg.setRecipient(Message.RecipientType.TO, to);
			
			msg.setSubject("��й�ȣ�� �ؾ�����̳���?", "UTF-8");
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
		String Id = "1234";  //�׽�Ʈ�� ���� ��������ϴ� ���̵� �־��ּ���
		char[] pw = {1234};  //�׽�Ʈ�� ���� �ش���̵��� ��й�ȣ�� �־��ּ���
		account = new PasswordAuthentication(Id, pw);
	}

	public PasswordAuthentication getPasswordAuthentication() {
		return account;
	}
}
