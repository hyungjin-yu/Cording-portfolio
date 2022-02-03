package Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FindFrame extends JFrame implements ActionListener {

	ImagePanel panel = new ImagePanel(
	        new ImageIcon("BackGround/LogInBg.png").getImage());
	
	// 아이디, 비번 찾기 창
	Container container = getContentPane();
	JPanel jp1 = new JPanel();
	JLabel dlfind = new JLabel("  ", JLabel.CENTER);
	JPanel d2center = new JPanel();
	JPanel d2top = new JPanel();
	JPanel d2pempty1 = new JPanel();
	JPanel d2pempty2 = new JPanel();
	JLabel d2empty5 = new JLabel("              ");
	JLabel d2empty6 = new JLabel("              ");

	JPanel d2topleft = new JPanel();
	JLabel d2empty1 = new JLabel("");
	JLabel d2lname = new JLabel("        이름        ", JLabel.RIGHT);
	JLabel d2lmail1 = new JLabel("        E-mail        ", JLabel.RIGHT);
	JLabel d2empty2 = new JLabel("");

	JPanel d2topright = new JPanel();
	JLabel d2ltop = new JLabel("ID 찾기", JLabel.LEFT);
	JTextField d2tname = new JTextField(15);
	JTextField d2tmail1 = new JTextField(15);
	JPanel d2check1 = new JPanel();
	RoundedButton d2btcheck1 = new RoundedButton("확인");
	JTextField d2l1 = new JTextField(15) {
		@Override
		public void setBorder(Border border) {
		}
	};

	JPanel d2bottom = new JPanel();
	JPanel d2btleft = new JPanel();
	JLabel d2empty3 = new JLabel("");
	JLabel d2lid = new JLabel("        ID        ", JLabel.RIGHT);
	JLabel d2lmail2 = new JLabel("        E-mail        ", JLabel.RIGHT);
	JLabel d2empty4 = new JLabel("");

	JPanel d2btright = new JPanel();
	JLabel d2lbottom = new JLabel("P/W 찾기", JLabel.LEFT);
	JTextField d2tid = new JTextField(15);
	JTextField d2tmail2 = new JTextField(15);
	JPanel d2check2 = new JPanel();
	RoundedButton d2btcheck2 = new RoundedButton("확인");
	JTextField d2l2 = new JTextField(15) {
		@Override
		public void setBorder(Border border) {
		}
	};
	JPanel prb = new JPanel();
	RoundedButton rb1 = new RoundedButton("취소");
	RoundedButton rb2 = new RoundedButton("닫기");
	
	// 필요변수 선언
	String id, name, mail;
	List<LogInDTO> list = null;
	LogInDAO logindao = new LogInDAO();

	public FindFrame() {
		setTitle("ALBA Heaven Find ID / PW");
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		// 아이디, 비밀번호 찾기 창
		container.add(jp1);
		jp1.setBackground(new Color(255, 230, 238));

		jp1.setLayout(new BorderLayout());
		jp1.add("North", panel);
		jp1.add("Center", d2center);
		jp1.add("South", prb);
		
		prb.setBackground(new Color(255, 230, 238));
		prb.setLayout(new FlowLayout(FlowLayout.CENTER));
		prb.add(rb1);
		prb.add(rb2);

		d2center.setLayout(new GridLayout(2, 1, 5, 5));
		d2center.add(d2top);
		d2center.add(d2bottom);

		d2top.setLayout(new BorderLayout());
		d2top.add("West", d2topleft);
		d2top.add("Center", d2topright);
		d2top.add("East", d2pempty1);

		d2pempty1.add(d2empty5);

		d2topleft.setLayout(new GridLayout(4, 1, 5, 5));
		d2topleft.add(d2empty1);
		d2topleft.add(d2lname);
		d2topleft.add(d2lmail1);
		d2topleft.add(d2empty2);

		d2topright.setLayout(new GridLayout(4, 1, 5, 5));
		d2topright.add(d2ltop);
		d2topright.add(d2tname);
		d2topright.add(d2tmail1);
		d2topright.add(d2check1);

		d2check1.setLayout(new FlowLayout(FlowLayout.LEFT));
		d2check1.add(d2btcheck1);
		d2check1.add(d2l1);
		d2l1.setEditable(false);
		d2l1.setBackground(new Color(255, 230, 238));

		d2bottom.setLayout(new BorderLayout());
		d2bottom.add("West", d2btleft);
		d2bottom.add("Center", d2btright);
		d2bottom.add("East", d2pempty2);

		d2pempty2.add(d2empty6);

		d2btleft.setLayout(new GridLayout(4, 1, 5, 5));
		d2btleft.add(d2empty3);
		d2btleft.add(d2lid);
		d2btleft.add(d2lmail2);
		d2btleft.add(d2empty4);

		d2btright.setLayout(new GridLayout(4, 1, 5, 5));
		d2btright.add(d2lbottom);
		d2btright.add(d2tid);
		d2btright.add(d2tmail2);
		d2btright.add(d2check2);

		d2check2.setLayout(new FlowLayout(FlowLayout.LEFT));
		d2check2.add(d2btcheck2);
		d2check2.add(d2l2);
		d2l2.setEditable(false);
		d2l2.setBackground(new Color(255, 230, 238));

		dlfind.setFont(new Font("맑은고딕", Font.BOLD, 55));
		d2ltop.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		d2lbottom.setFont(new Font("맑은고딕", Font.PLAIN, 20));
		d2center.setBackground(new Color(255, 0, 0, 0));
		d2top.setBackground(new Color(255, 0, 0, 0));
		d2pempty1.setBackground(new Color(255, 0, 0, 0));
		d2pempty2.setBackground(new Color(255, 0, 0, 0));
		d2topleft.setBackground(new Color(255, 0, 0, 0));
		d2topright.setBackground(new Color(255, 0, 0, 0));
		d2check1.setBackground(new Color(255, 0, 0, 0));
		d2bottom.setBackground(new Color(255, 0, 0, 0));
		d2btleft.setBackground(new Color(255, 0, 0, 0));
		d2btright.setBackground(new Color(255, 0, 0, 0));
		d2check2.setBackground(new Color(255, 0, 0, 0));
	}

	private void start() {
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		d2btcheck1.addActionListener(this);
		d2btcheck2.addActionListener(this);
		rb1.addActionListener(this);
		rb2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 취소, 닫기 버튼
		if (e.getSource() == rb1) {
			d2tname.setText("");
			d2tmail1.setText("");
			d2l1.setText("");
			d2tid.setText("");
			d2tmail2.setText("");
			d2l2.setText("");	
		} else if (e.getSource() == rb2) {
			setVisible(false);
		}
		
		
		// ID 찾기 버튼, P/W 찾기 버튼
		if (e.getSource() == d2btcheck1) {
			name = d2tname.getText();
			mail = d2tmail1.getText();

			if (name.equals("") || mail.equals("")) {
				d2l1.setText("정보를 정확히 입력하세요");
			} else {
				list = logindao.searchID(name, mail);
				String str = "";

				if (list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						str = "ID : " + list.get(i).toString();
					}
				} else {
					str = "회원정보를 찾을 수 없습니다.";
				}
				d2l1.setText(str);
			}
		} else if (e.getSource() == d2btcheck2) {
			id = d2tid.getText();
			mail = d2tmail2.getText();
			if (id.equals("") || mail.equals("")) {
				d2l2.setText("정보를 정확히 입력하세요");
			} else {
				list = logindao.searchPW(id, mail);
				String str = "";
				if (list.size() > 0) {
					boolean mailSuccess = logindao.sendMail(mail, list);
					if (mailSuccess == true) {
						str = "등록 된 이메일에 수신된 메일을 확인해주세요.";
					} else if (mailSuccess == false) {
						str = "알 수 없는 오류 발생, 다시 시도해주세요.";
					}
				} else {
					str = "회원정보를 찾을 수 없습니다.";
				}
				d2l2.setText(str);
			}
		}
	}
}