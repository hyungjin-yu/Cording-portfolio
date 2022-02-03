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
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JoinFrame extends JFrame implements ActionListener {

	Container container = getContentPane();
	JPanel jp2 = new JPanel();
	JLabel dljoin = new JLabel("알바헤븐 회원가입", JLabel.CENTER);

	JPanel dpcenter = new JPanel();
	JPanel dpleft = new JPanel();
	JLabel dlid = new JLabel("ID    ", JLabel.RIGHT);
	JLabel l1 = new JLabel("");
	JLabel dlpw = new JLabel("P/W    ", JLabel.RIGHT);
	JLabel dlname = new JLabel("이름    ", JLabel.RIGHT);
	JLabel dlbirth = new JLabel("      생년월일    ", JLabel.RIGHT);
	JLabel dlgender = new JLabel("성별    ", JLabel.RIGHT);
	JLabel dlphone = new JLabel("연락처    ", JLabel.RIGHT);
	JLabel dladd = new JLabel("주소    ", JLabel.RIGHT);
	JLabel dlmail = new JLabel("E-mail    ", JLabel.RIGHT);
	JLabel l2 = new JLabel("");

	JPanel dpmiddle = new JPanel();
	JTextField dtid = new JTextField(15);
	JPasswordField dtpw = new JPasswordField(15);
	JTextField dtname = new JTextField(15);
	JTextField dtbirth = new JTextField(15);
	JPanel drbt = new JPanel();
	JRadioButton jrbt1 = new JRadioButton("여", true);
	JRadioButton jrbt2 = new JRadioButton("남");
	ButtonGroup btgp = new ButtonGroup();
	JTextField dtphone = new JTextField(15);
	JTextField dtadd = new JTextField(15);
	JTextField dtmail = new JTextField(15);
	JTextField dlcheck1 = new JTextField("검사결과 : ") {
		@Override
		public void setBorder(Border border) {
		}
	};
	JTextField dlcheck2 = new JTextField("검사결과 : ") {
		@Override
		public void setBorder(Border border) {
		}
	};

	JPanel dpright = new JPanel();
	JPanel dpright1 = new JPanel();
	JPanel dpright2 = new JPanel();
	RoundedButton dbcheck1 = new RoundedButton("중복체크");
	RoundedButton dbcheck2 = new RoundedButton("중복체크");
	JLabel l3 = new JLabel("");
	JLabel l4 = new JLabel("");
	JLabel l5 = new JLabel("");
	JLabel l6 = new JLabel("");
	JLabel l7 = new JLabel("");
	JLabel l8 = new JLabel("");
	JLabel l9 = new JLabel("");
	JLabel l10 = new JLabel("");
	JLabel l11 = new JLabel("      ");
	JLabel l12 = new JLabel("      ");

	JPanel dpbottom = new JPanel();
	RoundedButton dbt1 = new RoundedButton("저장");
	RoundedButton dbt2 = new RoundedButton("취소");
	RoundedButton dbt3 = new RoundedButton("닫기");
	

	// 일반 경고창
	JDialog dialog = new JDialog();
	Container dialogContainer = dialog.getContentPane();
	JPanel dialp = new JPanel();
	JLabel dialogJLabel = new JLabel("", JLabel.CENTER);

	// 필요변수 선언
	String id, password, name, birth, phone, address, mail, gender;
	boolean fm = false;
	List<LogInDTO> list = null;
	LogInDAO logindao = new LogInDAO();
	int result = 0;

	public JoinFrame() {
		setTitle("ALBA Heaven Join");
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		// 회원가입 창
		container.add(jp2);
		jp2.setBackground(new Color(255, 230, 238));

		jp2.setLayout(new BorderLayout());
		jp2.add("North", dljoin);
		jp2.add("Center", dpcenter);
		jp2.add("South", dpbottom);

		dpbottom.setLayout(new FlowLayout(FlowLayout.CENTER));
		dpbottom.add(dbt1);
		dpbottom.add(dbt2);
		dpbottom.add(dbt3);

		dpcenter.setLayout(new BorderLayout());
		dpcenter.add("West", dpleft);
		dpcenter.add("Center", dpmiddle);
		dpcenter.add("East", dpright);

		dpleft.setLayout(new GridLayout(10, 1, 15, 15));
		dpleft.add(dlid);
		dpleft.add(l1);
		dpleft.add(dlpw);
		dpleft.add(dlname);
		dpleft.add(dlbirth);
		dpleft.add(dlgender);
		dpleft.add(dlphone);
		dpleft.add(dladd);
		dpleft.add(dlmail);
		dpleft.add(l2);

		dpright.setLayout(new GridLayout(10, 1, 15, 15));
		dpright.add(dpright1);
		dpright.add(l3);
		dpright.add(l4);
		dpright.add(l5);
		dpright.add(l6);
		dpright.add(l7);
		dpright.add(l8);
		dpright.add(l9);
		dpright.add(dpright2);
		dpright.add(l10);

		dpright1.setLayout(new BorderLayout());
		dpright1.add("Center", dbcheck1);
		dpright1.add("East", l11);

		dpright2.setLayout(new BorderLayout());
		dpright2.add("Center", dbcheck2);
		dpright2.add("East", l12);

		dpmiddle.setLayout(new GridLayout(10, 1, 15, 15));
		dpmiddle.add(dtid);
		dpmiddle.add(dlcheck1);
		dlcheck1.setEditable(false);
		dlcheck1.setBackground(new Color(255, 230, 238));
		dpmiddle.add(dtpw);
		dpmiddle.add(dtname);
		dpmiddle.add(dtbirth);
		dpmiddle.add(drbt);
		dpmiddle.add(dtphone);
		dpmiddle.add(dtadd);
		dpmiddle.add(dtmail);
		dpmiddle.add(dlcheck2);
		dlcheck2.setEditable(false);
		dlcheck2.setBackground(new Color(255, 230, 238));

		drbt.setLayout(new FlowLayout(FlowLayout.CENTER));
		drbt.add(jrbt1);
		drbt.add(jrbt2);
		btgp.add(jrbt1);
		btgp.add(jrbt2);

		dljoin.setFont(new Font("맑은고딕", Font.BOLD, 25));
		dpcenter.setBackground(new Color(255, 0, 0, 0));
		dpleft.setBackground(new Color(255, 0, 0, 0));
		dpmiddle.setBackground(new Color(255, 0, 0, 0));
		drbt.setBackground(new Color(255, 0, 0, 0));
		dpright.setBackground(new Color(255, 0, 0, 0));
		dpright1.setBackground(new Color(255, 0, 0, 0));
		dpright2.setBackground(new Color(255, 0, 0, 0));
		dpbottom.setBackground(new Color(255, 0, 0, 0));
		jrbt1.setBackground(new Color(255, 230, 238));
		jrbt2.setBackground(new Color(255, 230, 238));

		// 일반 경고창
		dialog.setSize(300, 200);
		dialog.setLocationRelativeTo(null);
		dialog.add(dialp);
		dialp.setBackground(new Color(255, 230, 238));
		dialp.setLayout(new BorderLayout());
		dialp.add("Center", dialogJLabel);

	}

	private void start() {
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		dialog.setDefaultCloseOperation(HIDE_ON_CLOSE);
		jrbt1.addActionListener(this);
		jrbt2.addActionListener(this);
		dbt1.addActionListener(this);
		dbt2.addActionListener(this);
		dbt3.addActionListener(this);
		dbcheck1.addActionListener(this);
		dbcheck2.addActionListener(this);
	}

	@Override
	   public void actionPerformed(ActionEvent e) {
	      boolean doublecheck1 = false;
	      boolean doublecheck2 = false;
	      
	      // 회원가입 성별선택 버튼
	      if (e.getSource() == jrbt2) {
	         fm = true;
	      } else if (e.getSource() == jrbt1) {
	         fm = false;
	      }

	      // 회원가입 창 저장 & 취소버튼
	      if (e.getSource() == dbt1) {
	         if(doublecheck1 == false) {
	            dialogJLabel.setText("중복체크를 해주세요");
	            dialog.setVisible(true);
	            return;
	         }
	         if(doublecheck2 == false) {
	            dialogJLabel.setText("중복체크를 해주세요");
	            dialog.setVisible(true);
	            return;
	         }
	         
	         id = dtid.getText();
	         password = dtpw.getText();
	         name = dtname.getText();
	         birth = dtbirth.getText();
	         phone = dtphone.getText();
	         address = dtadd.getText();
	         mail = dtmail.getText();

	         if (fm == true) {
	            gender = "남자";
	         } else {
	            gender = "여자";
	         }

	         if (id.equals("") || password.equals("") || name.equals("") || birth.equals("") || phone.equals("")
	               || address.equals("") || mail.equals("")) {
	            dialogJLabel.setText("정보를 모두 입력하세요");
	            dialog.setVisible(true);
	            return;
	         }

	         LogInDTO logindto = new LogInDTO(id, password, name, birth, phone, address, mail, gender);
	         result = logindao.insert(logindto);

	         if (result > 0) {
	            dialogJLabel.setText("가입이 완료되었습니다.");
	            dialog.setVisible(true);
	            dtid.setText("");
	            dtpw.setText("");
	            dtname.setText("");
	            dtbirth.setText("");
	            dtphone.setText("");
	            dtadd.setText("");
	            dtmail.setText("");
	         } else {
	            dialogJLabel.setText("알 수 없는 오류 발생, 재시도하세요.");
	            dialog.setVisible(true);
	         }
	      } else if (e.getSource() == dbt2) {
	         dtid.setText("");
	         dlcheck1.setText("검사결과 : ");
	         dtpw.setText("");
	         dtname.setText("");
	         dtbirth.setText("");
	         dtphone.setText("");
	         dtadd.setText("");
	         dtmail.setText("");
	         dlcheck2.setText("검사결과 : ");
	         dbt1.setEnabled(true);
	      }
	      
	      // 회원가입 창 닫기 버튼
	      if (e.getSource() == dbt3) {
	         setVisible(false);
	      }

	      // 회원가입 창 아이디 중복체크, 이메일 중복체크 버튼
	      if (e.getSource() == dbcheck1) {
	         doublecheck1 = true;
	         id = dtid.getText();
	         if (id.equals("")) {
	            dlcheck1.setText("검사결과 : ID를 입력하세요");
	         } else {
	            list = logindao.selectID(id);
	            if (list.size() > 0) {
	               dlcheck1.setText("검사결과 : 이미 사용중인 ID 입니다.");
	               dtid.setText("");
	               dbt1.setEnabled(false);
	            } else {
	               dlcheck1.setText("검사결과 : 사용가능한 ID 입니다.");
	               dbt1.setEnabled(true);
	            }
	         }
	      } else if (e.getSource() == dbcheck2) {
	         doublecheck2 = true;
	         mail = dtmail.getText();
	         if (mail.equals("")) {
	            dlcheck2.setText("검사결과 : Mail을 입력하세요");
	         } else {
	            list = logindao.selecMail(mail);
	            if (list.size() > 0) {
	               dlcheck2.setText("검사결과 : 이미 사용중인 메일 입니다.");
	               dtid.setText("");
	               dbt1.setEnabled(false);
	            } else {
	               dlcheck2.setText("검사결과 : 사용가능한 메일 입니다.");
	               dbt1.setEnabled(true);
	            }
	         }
	      }
	   }
}