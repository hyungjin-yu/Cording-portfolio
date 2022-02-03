package admin;

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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import admin.AdminFrame;

public class AdminRegisterFrame extends JFrame implements ActionListener {
	// 비어있는 날짜칸을 눌렀을때 뜨는 입력 창 (알바정보 등록)
	Container container = getContentPane();
	
	// Panel
	JPanel panelCenter = new JPanel();
	JPanel panelButton = new JPanel();
	
	JPanel panelDate = new JPanel();
	JPanel panelTime = new JPanel();
	JPanel panelLoc = new JPanel();
	JPanel panelJob = new JPanel();
	JPanel panelDetails = new JPanel();
	JPanel panelWage = new JPanel();
	JPanel panelPayday = new JPanel();
	
	// Label
	JLabel labelDate = new JLabel("날짜");
	JLabel labelTime = new JLabel("시간");
	JLabel labelTimeWaveDash = new JLabel(" ~ ");
	JLabel labelLoc = new JLabel("장소");
	JLabel labelJob = new JLabel("하는 일");
	JLabel labelDetails = new JLabel("세부내용");
	JLabel labelWage = new JLabel("시급");
	JLabel labelPayday = new JLabel("지급일");
	JLabel labelPaydayYear = new JLabel("년 ");
	JLabel labelPaydayMonth = new JLabel("월 ");
	JLabel labelPaydayDay = new JLabel("일");
	
	// ComboBox
	// time
	String[] arrTime = new String[24];
	JComboBox<String> cbxTime1 = null;
	JComboBox<String> cbxTime2 = null;
	// year
	String[] arrYear = new String[5];
	JComboBox<String> cbxYear = null;
	// month
	String[] arrMonth = new String[12];
	JComboBox<String> cbxMonth = null;
	// day
	String[] arrDay = new String[31];
	JComboBox<String> cbxDay = null;
	
	// TextField
	JTextField tfLoc = new JTextField(20);
	JTextField tfJob = new JTextField(20);
	JTextField tfDetails = new JTextField(20);
	JTextField tfWage = new JTextField(20);
	
	// Button
	RoundedButton buttonRegister = new RoundedButton("등록");
	RoundedButton buttonCancel = new RoundedButton("취소");
	
	// DB
	AdminDAO dao = new AdminDAO();
	List<AdminDTO> list = null;
	
	public AdminRegisterFrame(String date) {
		System.out.println();
		setTitle("알바 등록");
		setSize(300, 500);
		setLocationRelativeTo(null);
		init(date);
		start();
		setVisible(true);
		setResizable(false);
	}

	private void init(String date) {
		container.setBackground(Color.WHITE);
		container.setLayout(new BorderLayout());
		container.add("Center", panelCenter);
		container.add("South", panelButton);
		
		// panelCenter
		panelCenter.setBackground(Color.WHITE);
		panelCenter.setLayout(new GridLayout(7, 1));
		panelCenter.add(panelDate);
		panelCenter.add(panelTime);
		panelCenter.add(panelLoc);
		panelCenter.add(panelJob);
		panelCenter.add(panelDetails);
		panelCenter.add(panelWage);
		panelCenter.add(panelPayday);
		panelCenter.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// panelDate
		panelDate.setBackground(Color.WHITE);
		panelDate.setLayout(new FlowLayout());
		panelDate.add(labelDate);
		labelDate.setText(date);
		labelDate.setAlignmentX(CENTER_ALIGNMENT);
		labelDate.setFont(new Font("Gothic", Font.BOLD, 20));
		
		// panelTime
		for(int i=0; i<arrTime.length; i++) {
			arrTime[i] = Integer.toString(i)+":00";
		}
		cbxTime1 = new JComboBox<String>(arrTime);
		cbxTime2 = new JComboBox<String>(arrTime);
		cbxTime1.setEditable(false);
		cbxTime2.setEditable(false);
		panelTime.setBackground(Color.WHITE);
		panelTime.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelTime.add(labelTime);
		panelTime.add(cbxTime1);
		panelTime.add(labelTimeWaveDash);
		panelTime.add(cbxTime2);
		// panelLoc
		panelLoc.setBackground(Color.WHITE);
		panelLoc.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelLoc.add(labelLoc);
		panelLoc.add(tfLoc);
		// panelJob
		panelJob.setBackground(Color.WHITE);
		panelJob.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelJob.add(labelJob);
		panelJob.add(tfJob);
		// panelDetails
		panelDetails.setBackground(Color.WHITE);
		panelDetails.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelDetails.add(labelDetails);
		panelDetails.add(tfDetails);
		// panelHWage
		panelWage.setBackground(Color.WHITE);
		panelWage.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelWage.add(labelWage);
		panelWage.add(tfWage);
		
		// panelPayday
		
		// year
		for(int i=0; i<arrYear.length; i++) {
			arrYear[i] = Integer.toString(i+2022);
		}
		cbxYear = new JComboBox<String>(arrYear);
		
		// month
		for(int i=0; i<arrMonth.length; i++) {
			arrMonth[i] = Integer.toString(i+1);
		}
		cbxMonth = new JComboBox<String>(arrMonth);
		
		/*cbxMonth.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				int selectedMonth = Integer.parseInt(cbxMonth.getSelectedItem().toString());
				if(selectedMonth%2==0) {
					if(selectedMonth==2) {
						arrDay = new String[28];				
					}
					arrDay = new String[30];
				}
			}
		});
		*/
		
		// day
		for(int i=0; i<arrDay.length; i++) {
			arrDay[i] = Integer.toString(i+1);
		}
		cbxDay = new JComboBox<String>(arrDay);
		
		cbxYear.setEditable(false);
		cbxMonth.setEditable(false);
		cbxDay.setEditable(false);
		
		panelPayday.setBackground(Color.WHITE);
		panelPayday.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelPayday.add(labelPayday);
		panelPayday.add(cbxYear);
		panelPayday.add(labelPaydayYear);
		panelPayday.add(cbxMonth);
		panelPayday.add(labelPaydayMonth);
		panelPayday.add(cbxDay);
		panelPayday.add(labelPaydayDay);
		
		// button
		panelButton.setBackground(Color.WHITE);
		panelButton.setLayout(new FlowLayout());
		panelButton.add(buttonRegister);	// 등록
		panelButton.add(buttonCancel);		// 취소
		panelButton.setBorder(new EmptyBorder(10, 10, 30, 10));
		
	}
	
	private void start() {
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		buttonRegister.addActionListener(this);
		buttonCancel.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String date = labelDate.getText();
		String time1_str = cbxTime1.getSelectedItem().toString();
		String time2_str = cbxTime2.getSelectedItem().toString();
		String time1 = time1_str.substring(0, time1_str.indexOf(":"));
		String time2 = time2_str.substring(0, time2_str.indexOf(":"));
		String loc = tfLoc.getText();
		String job = tfJob.getText();
		String details = tfDetails.getText();
		String wage_str = tfWage.getText();
		String payday = cbxYear.getSelectedItem().toString() + "년 "
				+ cbxMonth.getSelectedItem().toString() + "월 "
				+ cbxDay.getSelectedItem().toString() + "일";
		System.out.println(payday);
		// 등록
		if(e.getSource() == buttonRegister) {
			
			// 입력 검사
			
			if(!(time1.equals("") || time2.equals("") || loc.equals("") || job.equals("") || details.equals("") || 
					wage_str.equals("") || !(wage_str.chars().allMatch( Character::isDigit )) || payday.equals(""))) {
				
				int registerConfirm = JOptionPane.showConfirmDialog(this, "알바 정보를 등록하시겠습니까?", "알바 정보 등록", 
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				switch(registerConfirm) {
				case 0:	// OK
					
					// DB
					AdminDTO dto = new AdminDTO();
					dto.setDate(date);
					dto.setTime1(Integer.parseInt(time1));
					dto.setTime2(Integer.parseInt(time2));
					dto.setLoc(loc);
					dto.setJob(job);
					dto.setDetails(details);
					dto.setWage(Integer.parseInt(wage_str));
					dto.setPayday(payday);
					
					int result = dao.insert(dto);
					
					if(result > 0) {
						JOptionPane.showMessageDialog(this, "등록되었습니다.", "MESSAGE", 
								JOptionPane.INFORMATION_MESSAGE);
						
						// textField 초기화
						tfLoc.setText("");
						tfJob.setText("");
						tfDetails.setText("");
						tfWage.setText("");
						dispose();
						AdminFrame adminFrame = new AdminFrame(null);
						dispose();
					} else {
						JOptionPane.showMessageDialog(this, "등록에 실패했습니다.", "MESSAGE", 
								JOptionPane.WARNING_MESSAGE);
					}
					break;
				case 2:	// CANCEL
					break;
				}
				
			} else {
				JOptionPane.showMessageDialog(this, "등록에 실패했습니다.\n올바르게 입력해주세요.", "MESSAGE", 
						JOptionPane.WARNING_MESSAGE);
			}
			
			/*
			if(time.equals("")) {
				tfTime.setBorder(new LineBorder(Color.RED, 2));
			} else if(time.length() > 0) {
				tfTime.setBorder(null);
			}
			
				
			if(loc.equals("")) {
				tfLoc.setBorder(new LineBorder(Color.RED, 2));
			} else if(loc.length() > 0) {
				tfLoc.setBorder(null);
			}
				
			if(job.equals("")) {
				tfJob.setBorder(new LineBorder(Color.RED, 2));
			} else {
				tfJob.setBorder(null);
			}
				
			if(details.equals("")) {
				tfDetails.setBorder(new LineBorder(Color.RED, 2));
			} else {
				tfDetails.setBorder(null);
			}
				
			if(wage_str.equals("")) {
				tfWage.setBorder(new LineBorder(Color.RED, 2));
			} else if(!(wage_str.chars().allMatch( Character::isDigit ))) {	// wage_str.matches("[+-]?\\d*(\\.\\d+)?")
				tfWage.setBorder(new LineBorder(Color.RED, 2));
				// "숫자만 입력가능합니다." hint text field?
			} else {
				tfWage.setBorder(null);
			}
				
			if(payday.equals("")) {
				tfPayday.setBorder(new LineBorder(Color.RED, 2));
			} else {
				tfPayday.setBorder(null);
			}
			*/
			
			
			
		// 등록취소(창 닫기)
		} else if(e.getSource() == buttonCancel) {
			
			if(time1.equals("") && time2.equals("") && loc.equals("") && job.equals("") && details.equals("") && wage_str.equals("") && payday.equals("")) {
				dispose();
			} else {	// textField에 값이 하나라도 있으면
				int cancelConfirm = JOptionPane.showConfirmDialog(this, "입력 중인 정보가 모두 지워집니다. \n창을 닫으시겠습니까?", "!", 
						JOptionPane.OK_CANCEL_OPTION, 
						JOptionPane.QUESTION_MESSAGE);
				switch(cancelConfirm) {
				case 0:	// OK
					dispose();
					break;
				case 2:	// CANCEL(창 닫기)
					break;
				}
			}
		}
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
	      Color c = new Color(255, 221, 219); // 배경색 결정
	      Color o = new Color(54, 54, 54); // 글자색 결정
	      Color a = new Color(253, 175, 200);	// isArmed, isRollover
	      int width = getWidth();
	      int height = getHeight();
	      Graphics2D graphics = (Graphics2D) g;
	      graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	      if (getModel().isArmed()) {
	         //graphics.setColor(c.darker());
	    	  graphics.setColor(a);
	      } else if (getModel().isRollover()) {
	         //graphics.setColor(c.brighter());
	    	  graphics.setColor(a);
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

