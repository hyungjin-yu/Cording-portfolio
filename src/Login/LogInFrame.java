package Login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import admin.AdminFrame;
import apply.ApplyDTO;
import apply.Applymain;
import apply.Apply;

public class LogInFrame extends JFrame implements ActionListener {

	ImagePanel panel = new ImagePanel(
	        new ImageIcon("BackGround/LogInBg.png").getImage());
		
	// 로그인 창
	Container container = getContentPane();
	JPanel jp = new JPanel();
	JLabel ltitle = new JLabel("            ");

	JPanel ptop = new JPanel();
	JPanel pid = new JPanel();
	JPanel ppw = new JPanel();
	JPanel pcenter = new JPanel();
	JPanel pmiddle = new JPanel();
	JPanel pbottom = new JPanel();
	JPanel pjoin = new JPanel();

	JLabel lid = new JLabel("                       ID    ");
	JLabel lpw = new JLabel("        Password    ");
	JLabel lempty1 = new JLabel("                    ");
	JLabel lempty2 = new JLabel("                    ");
	JLabel lempty3 = new JLabel("                 알바의 천국 ? 알바헤븐 !");
	JLabel ljoin = new JLabel("계정이 없거나 기억나지 않는다면?!", JLabel.CENTER);

	JTextField tid = new JTextField(20);
	JPasswordField tpw = new JPasswordField(20);

	RoundedButton bloginAlba = new RoundedButton("  회원 로그인  ");
	RoundedButton bloginAdmin = new RoundedButton("관리자 로그인");
	RoundedButton bjoin = new RoundedButton("  회원가입  ");
	RoundedButton bfind = new RoundedButton("ID/PW 찾기");

	// 일반 경고창
	JDialog dialog = new JDialog();
	Container dialogContainer = dialog.getContentPane();
	JPanel dialp = new JPanel();
	JLabel dialogJLabel = new JLabel("", JLabel.CENTER);

	// 필요변수 선언
	String id, password;
	LogInDAO logindao = new LogInDAO();

	public LogInFrame() {
		setTitle("ALBA Heaven");
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		// 로그인 창
		container.add(jp);
		jp.setBackground(new Color(255, 230, 238));

		jp.setLayout(new BorderLayout());
		jp.add("North", panel);
		jp.add("Center", pcenter);

		pcenter.setLayout(new GridLayout(2, 1, 15, 15));
		pcenter.add(ptop);
		pcenter.add(pbottom);

		ptop.setLayout(new BorderLayout());
		ptop.add("West", pid);
		ptop.add("Center", ppw);
		ptop.add("East", lempty1);

		pid.setLayout(new GridLayout(3, 1, 3, 3));
		pid.add(lempty2);
		pid.add(lid);
		pid.add(lpw);

		ppw.setLayout(new GridLayout(3, 1, 3, 3));
		ppw.add(lempty3);
		ppw.add(tid);
		ppw.add(tpw);

		pbottom.setLayout(new GridLayout(3, 1, 3, 3));
		pbottom.add(pmiddle);
		pbottom.add(ljoin);
		pbottom.add(pjoin);

		pmiddle.setLayout(new FlowLayout(FlowLayout.CENTER));
		pmiddle.add(bloginAdmin);
		pmiddle.add(bloginAlba);

		pjoin.setLayout(new FlowLayout(FlowLayout.CENTER));
		pjoin.add(bfind);
		pjoin.add(bjoin);

		ltitle.setFont(new Font("맑은고딕", Font.BOLD, 50));
		lempty3.setFont(new Font("맑은고딕", Font.BOLD, 15));
		ptop.setBackground(new Color(255, 0, 0, 0));
		pid.setBackground(new Color(255, 0, 0, 0));
		ppw.setBackground(new Color(255, 0, 0, 0));
		pcenter.setBackground(new Color(255, 0, 0, 0));
		pmiddle.setBackground(new Color(255, 0, 0, 0));
		pbottom.setBackground(new Color(255, 0, 0, 0));
		pjoin.setBackground(new Color(255, 0, 0, 0));

		// 일반 경고창
		dialog.setSize(300, 200);
		dialog.setLocationRelativeTo(null);
		dialog.add(dialp);
		dialp.setBackground(new Color(255, 230, 238));
		dialp.setLayout(new BorderLayout());
		dialp.add("Center", dialogJLabel);
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		dialog.setDefaultCloseOperation(HIDE_ON_CLOSE);
		bloginAlba.addActionListener(this);
		bloginAdmin.addActionListener(this);
		bfind.addActionListener(this);
		bjoin.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 로그인 (알바,관리자) 버튼

		if (e.getSource() == bloginAdmin) {
			id = tid.getText();
			password = tpw.getText();
			boolean check = logindao.LoginCheck(id, password);
			if (check == true) {
				AdminFrame admin = new AdminFrame(id);
				this.dispose();
			} else {
				dialogJLabel.setText("ID / 비밀번호 가 잘못되었거나 회원정보가 없습니다.");
				dialog.setVisible(true);
				tid.setText("");
				tpw.setText("");
				return;
			}
		} else if (e.getSource() == bloginAlba) {
			id = tid.getText();
			password = tpw.getText();
			boolean check = logindao.LoginCheckApply(id, password);
			if (check == true) {
				ApplyDTO apply = new ApplyDTO();
				apply.setId(id);
				System.out.println(apply.getId());
				Applymain am = new Applymain();
				am.main(null);
				this.dispose();
			} else {
				dialogJLabel.setText("ID / 비밀번호 가 잘못되었거나 회원정보가 없습니다.");
				dialog.setVisible(true);
				tid.setText("");
				tpw.setText("");
				return;
			}
		}	
		
		// 아이디, 비밀번호 찾기 & 회원가입 버튼
		if (e.getSource() == bfind) {
			FindFrame ff = new FindFrame();
			ff.d2tname.setText("");
			ff.d2tmail1.setText("");
			ff.d2l1.setText("");
			ff.d2tid.setText("");
			ff.d2tmail2.setText("");
			ff.d2l2.setText("");
		} else if (e.getSource() == bjoin) {
			JoinFrame jf = new JoinFrame();
		}
	}
}

class ImagePanel extends JPanel {

	private Image img;

	public ImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}

	public ImagePanel(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}

	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}

class RoundedButton extends JButton {
	public RoundedButton() {
		super();
		decorate();
	}

	public RoundedButton(String text) {
		super(text);
		decorate();
	}

	public RoundedButton(Action action) {
		super(action);
		decorate();
	}

	public RoundedButton(Icon icon) {
		super(icon);
		decorate();
	}

	public RoundedButton(String text, Icon icon) {
		super(text, icon);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Color c = new Color(157, 83, 83); // 배경색 결정
		Color o = new Color(255, 255, 255); // 글자색 결정
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if (getModel().isArmed()) {
			graphics.setColor(c.darker());
		} else if (getModel().isRollover()) {
			graphics.setColor(c.brighter());
		} else {
			graphics.setColor(c);
		}
		graphics.fillRoundRect(0, 0, width, height, 10, 10);
		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
		graphics.setColor(o);
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();
		super.paintComponent(g);
	}
}