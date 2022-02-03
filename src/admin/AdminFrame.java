package admin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalButtonUI;

import admin.AdminDetailsFrame;
import admin.AdminRegisterFrame;
import apply.ApplyDAO;
import apply.ApplyDTO;

public class AdminFrame extends JFrame implements ActionListener {
	Container container = getContentPane();

	// 선언
	// Panel
	JPanel panelCalendarBind = new JPanel();
	JPanel panelCalendarTop = new JPanel();			// North
	JPanel panelCalendar = new JPanel();			// Center
	JPanel panelLogOut = new JPanel();
	
	
	// Button & Label
	RoundedLabel buttonBefore = new RoundedLabel("<");
	RoundedLabel buttonAfter = new RoundedLabel(">");
	RoundedButton buttonLogOut = new RoundedButton("로그아웃");
	JLabel label = new JLabel("년 월");
	
	JButton[] buttons = new JButton[49];
	String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"};
	
	JLabel labelJob = null;
	RoundedLabel labelStatus = null;
	
	// HCalendar 객체 생성
	HCalendar hCalendar = new HCalendar(buttons);
	
	// DB
	AdminDAO adminDAO = new AdminDAO();
	List<AdminDTO> adminList = new ArrayList<AdminDTO>();
	
	ApplyDAO applyDAO = new ApplyDAO();
	List<ApplyDTO> applyList = new ArrayList<ApplyDTO>();
	
	
	public AdminFrame(String id) {
		setTitle("일일 알바 신청 프로그램 - 관리자");
		setSize(700, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		init();
		start();
		setVisible(true);
	}
	
	private void init() {
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(panelCalendarBind);
		container.add(panelLogOut);
		
		panelLogOut.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelLogOut.add(buttonLogOut);
		panelLogOut.setBorder(new EmptyBorder(0, 0, 10, 10));
		
		panelCalendarBind.setLayout(new BorderLayout());
		panelCalendarBind.add("North", panelCalendarTop);
		panelCalendarBind.add("Center", panelCalendar);
		panelCalendarBind.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// North : panelCalendarTop
		panelCalendarTop.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelCalendarTop.add(buttonBefore);
		panelCalendarTop.add(label);
		panelCalendarTop.add(buttonAfter);
		
		label.setFont(new Font("Gothic", Font.BOLD, 18));
		buttonBefore.setFont(new Font("Gothic", Font.BOLD, 20));
		buttonAfter.setFont(new Font("Gothic", Font.BOLD, 20));
		
		// Center : panelCalendar
		panelCalendar.setLayout(new GridLayout(7, 7, 3, 3));
		for(int i=0; i<buttons.length; i++) {
			buttons[i] = new JButton();
			panelCalendar.add(buttons[i]);
			buttons[i].setFont(new Font("Gothic", Font.BOLD, 14));
			buttons[i].setBackground(Color.WHITE);
			
			buttons[i].setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
			buttons[i].setBorderPainted(false);
			buttons[i].setFocusPainted(false);
			
			buttons[i].setHorizontalAlignment(SwingConstants.LEFT);
			buttons[i].setVerticalAlignment(SwingConstants.TOP);
			
			if(i<7) {
				buttons[i].setText(dayNames[i]);	// 버튼에 요일 출력
				
				buttons[i].setFont(new Font("Gothic", Font.BOLD, 20));
				buttons[i].setHorizontalAlignment(SwingConstants.CENTER);
				buttons[i].setVerticalAlignment(SwingConstants.CENTER);
				buttons[i].setEnabled(false);
				
				if(i%7 == 0) {
					buttons[i].setUI(new MetalButtonUI() {
					    protected Color getDisabledTextColor() {
					        return Color.RED;
					    }
					});
				} else if(!(i%7 == 0 || i%7 == 6)) {
					buttons[i].setUI(new MetalButtonUI() {
					    protected Color getDisabledTextColor() {
					        return Color.BLACK;
					    }
					});
				} else if(i%7 == 6) {
					buttons[i].setUI(new MetalButtonUI() {
					    protected Color getDisabledTextColor() {
					        return Color.BLUE;
					    }
					});
				}
			}
			if(i%7 == 0) {
				buttons[i].setForeground(Color.RED);
			} else if(i%7 == 6) {
				buttons[i].setForeground(Color.BLUE);
			}
		}
		
		// 날짜 출력
		label.setText(hCalendar.getCalText());
		hCalendar.calSet();
		
		// 날짜칸에 job 출력
		setLabelJob();
	}

	
	// 날짜칸에 job 출력
	public void setLabelJob() {
		// labelJob 초기화
		for(int i=0; i<buttons.length; i++) {
			buttons[i].removeAll();
		}
		
		// 신청된 날짜 모두 가져오기
		List<AdminDTO> workdaysList = new ArrayList<AdminDTO>();
		workdaysList = adminDAO.allWorkdays();
		labelJob = new JLabel();
		
		String year = Integer.toString(hCalendar.year);
		String month = Integer.toString(hCalendar.month);
		
		for(int i=0; i<buttons.length; i++) {
			String day = buttons[i].getText();
			String date = year + "년 " + month + "월 " + day + "일";
			
			for(int j=0; j<workdaysList.size(); j++) {
				// 이번달에 신청된 날짜 찾기
				if(date.equals(workdaysList.get(j).getDate())) {
					//확인용
					//System.out.println(date+"="+workdaysList.get(j).getDate());
					buttons[i].setLayout(new GridBagLayout());
					
					// labelStatus에 신청자 수 출력
					String str = setLabelStatus(workdaysList.get(j).getDate());
					if(!(str.equals(""))) {
						labelStatus = new RoundedLabel(str);
						labelStatus.setFont(new Font("Gothic", Font.BOLD, 10));
						
						buttons[i].add(labelStatus, 
								new GridBagConstraints(0, 0, 1, 1,
										1.0, 1.0,
										GridBagConstraints.FIRST_LINE_END, GridBagConstraints.NONE,
										new Insets(1, 1, 1, 1),
										0, 0));
					}
					
					// 신청된 날짜에 하는일 출력
					adminList = adminDAO.adminList(year + "년 " + month + "월 " + day + "일");
					labelJob = new JLabel(adminList.get(0).getJob());
					
					buttons[i].add(labelJob, 
							new GridBagConstraints(0, 0, 0, 0,
									0.0, 0.0,
									GridBagConstraints.CENTER, GridBagConstraints.NONE,
									new Insets(5, 5, 5, 5),
									0, 0));
				}
			}
		}
	}
	
	public String setLabelStatus(String date) {
		List<ApplyDTO> applyList = new ArrayList<ApplyDTO>();
		String str="";
		
		applyList = adminDAO.applyList(date);
		if(applyList.size() > 0) {
			for(int i=0; i<applyList.size(); i++) {
				if(applyList.get(i).getApproveStatus()==1) {
					str = "승인완료";
					break;
				} else {
					str = "신청자 " + Integer.toString(applyList.size()) + "명";
				}
			}
		} else {			
			
		}
		
		return str;
	}
	
	private void start() {
		// x버튼
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 이벤트 설정
		buttonBefore.addActionListener(this);
		buttonAfter.addActionListener(this);
		
		for(int i=0; i<buttons.length; i++) {
			buttons[i].addActionListener(this);
		}
		
		buttonLogOut.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonBefore) {
			hCalendar.allInit(-1);
			label.setText(hCalendar.getCalText());
			
			setLabelJob();
			
		} else if(e.getSource() == buttonAfter) {
			hCalendar.allInit(+1);
			label.setText(hCalendar.getCalText());
			
			setLabelJob();
		}
		
		// 날짜 칸 클릭
		String year = Integer.toString(hCalendar.year);
		String month = Integer.toString(hCalendar.month);
		for(int i=0; i<buttons.length; i++) {
			String day = buttons[i].getText();
			String date = year + "년 " + month + "월 " + day + "일";
			
			if((e.getSource() == buttons[i])) {
				if(buttons[i].getText().length() > 0) {	// button에 텍스트가 있으면(날짜 칸이면)
					// 0 : 빈 칸, 1 : 채워진 칸
					int isEmpty = adminDAO.isEmpty(date);
					if(isEmpty == 0) {	// 아무것도 등록되지 않은 빈 칸이면
						AdminRegisterFrame arf = new AdminRegisterFrame(date);
						
					} else {
						AdminDetailsFrame adf = new AdminDetailsFrame(date);
					}
				}
			}
		}
		if(e.getSource() == buttonLogOut) {
			dispose();
		}
	}
}

class RoundedLabel extends JButton {
	String text;
	
	public RoundedLabel() {
		super();
		decorate();
	}
	
	public RoundedLabel(String text) {
		super(text);
		this.text = text;
		decorate();
	}
	
	public RoundedLabel(Action action) {
		super(action);
		decorate();
	}
	
	public RoundedLabel(Icon icon) {
		super(icon);
		decorate();
	}
	
	public RoundedLabel(String text, Icon icon) {
		super(text, icon);
		decorate();
	}
	
	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Color lightPink = new Color(255, 221, 219);	// 배경색 결정
		Color lightBlue = new Color(214, 234, 255);
		Color blue = new Color(173, 211, 255);
		Color darkBlue = new Color(148, 201, 255);
		Color o = new Color(54, 54, 54);	// 글자색 결정
		int width = (int)(getWidth()*0.7);
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(text.equals("승인완료")) {
			graphics.setColor(lightPink);			
		} else if(text.equals("<") || text.equals(">")) {
			width = getWidth();
			if (getModel().isArmed()) {
				graphics.setColor(darkBlue);
			} else if (getModel().isRollover()) {
				graphics.setColor(blue);
			} else {
				graphics.setColor(lightBlue);
			}
		} else {
			graphics.setColor(lightBlue);
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

