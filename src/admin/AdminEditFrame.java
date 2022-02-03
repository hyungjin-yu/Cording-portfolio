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
import java.util.ArrayList;
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

public class AdminEditFrame extends JFrame implements ActionListener {
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
	RoundedButton buttonRegister = new RoundedButton("수정");
	RoundedButton buttonCancel = new RoundedButton("취소");
	
	// DB
	AdminDAO dao = new AdminDAO();
	List<AdminDTO> list = new ArrayList<AdminDTO>();
	
	public AdminEditFrame(String date) {
		System.out.println();
		setTitle("알바 정보 수정");
		setSize(300, 500);
		setLocationRelativeTo(null);
		init(date);
		start();
		setVisible(true);
		setResizable(false);
	}

	private void init(String date) {
		list = dao.adminList(date);
		
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
		cbxTime1.setSelectedIndex(list.get(0).getTime1());
		cbxTime2.setSelectedIndex(list.get(0).getTime2());
		// panelLoc
		panelLoc.setBackground(Color.WHITE);
		panelLoc.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelLoc.add(labelLoc);
		panelLoc.add(tfLoc);
		tfLoc.setText(list.get(0).getLoc());
		// panelJob
		panelJob.setBackground(Color.WHITE);
		panelJob.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelJob.add(labelJob);
		panelJob.add(tfJob);
		tfJob.setText(list.get(0).getJob());
		// panelDetails
		panelDetails.setBackground(Color.WHITE);
		panelDetails.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelDetails.add(labelDetails);
		panelDetails.add(tfDetails);
		tfDetails.setText(list.get(0).getDetails());
		// panelHWage
		panelWage.setBackground(Color.WHITE);
		panelWage.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panelWage.add(labelWage);
		panelWage.add(tfWage);
		tfWage.setText(Integer.toString(list.get(0).getWage()));
		
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
		
		String str = list.get(0).getPayday();
		String[] ymd = str.split("년 ");
		String y = ymd[0];
		String md = ymd[1];
		String[] md1 = md.split("월 ");
		String m = md1[0];
		String d1 = md1[1];
		String d = d1.substring(0, d1.indexOf("일"));
		
		cbxYear.setSelectedIndex(Integer.parseInt(y)-2022);
		cbxMonth.setSelectedIndex(Integer.parseInt(m)-1);
		cbxDay.setSelectedIndex(Integer.parseInt(d)-1);
		
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
		// 수정
		if(e.getSource() == buttonRegister) {
			
			// 입력 검사
			
			if(!(time1.equals("") || time2.equals("") || loc.equals("") || job.equals("") || details.equals("") || 
					wage_str.equals("") || !(wage_str.chars().allMatch( Character::isDigit )) || payday.equals(""))) {
				
				int registerConfirm = JOptionPane.showConfirmDialog(this, "알바 정보를 수정하시겠습니까?", "알바 정보 등록", 
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
					
					int result = dao.edit(dto);
					
					if(result > 0) {
						JOptionPane.showMessageDialog(this, "수정되었습니다.", "MESSAGE", 
								JOptionPane.INFORMATION_MESSAGE);
						
						// textField 초기화
						tfLoc.setText("");
						tfJob.setText("");
						tfDetails.setText("");
						tfWage.setText("");
						
						dispose();
						
					} else {
						JOptionPane.showMessageDialog(this, "수정 실패했습니다.", "MESSAGE", 
								JOptionPane.WARNING_MESSAGE);
					}
					
					break;
				case 2:	// CANCEL
					break;
				}
				
			} else {
				JOptionPane.showMessageDialog(this, "수정 실패했습니다.\n올바르게 입력해주세요.", "MESSAGE", 
						JOptionPane.WARNING_MESSAGE);
			}
			
		// 수정취소(창 닫기)
		} else if(e.getSource() == buttonCancel) {
			
			if(time1.equals("") && time2.equals("") && loc.equals("") && job.equals("") && details.equals("") && wage_str.equals("") && payday.equals("")) {
				dispose();
			} else {	// textField에 값이 하나라도 있으면
				int cancelConfirm = JOptionPane.showConfirmDialog(this, "수정 취소하시겠습니까?", "!", 
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
