package apply;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.text.AttributeSet.ColorAttribute;

class JFrames extends JFrame implements ActionListener {
	List<String> detail = new ArrayList<String>();
	Container container = getContentPane();

	// JPanel
	JPanel panelCenter = new JPanel();
	JPanel panelEast = new JPanel();
	JPanel panelCalender = new JPanel();
	JPanel panelTitle = new JPanel();
	JPanel panelDialog = new JPanel();

	// JButton
	JButton ButtonCancel = new JButton("신청취소");
	JButton ButtonNext = new JButton(">");
	JButton ButtonLast = new JButton("<");
	JButton[] buttons = new JButton[49];
	String[] dayNames = { "일", "월", "화", "수", "목", "금", "토" };
	InfinityCalender infinityCalender = new InfinityCalender(buttons);

	// JLabel
	JLabel LabelMyList = new JLabel("my 알바리스트");
	JLabel Labelmonth = new JLabel("월");
	JLabel LabelList = new JLabel("신청목록");
	JLabel LabelPay = new JLabel("my 알바비 <2022년 1월>"); // 나중에 달력 월 수에 맞게 바꿀 예정
	JLabel Labelmonths = new JLabel("2022년 1월");
	Font font = new Font("맑음고딕", Font.BOLD, 20);
	Font font2 = new Font("맑음고딕", Font.BOLD, 10);

	// JTextArea
	JTextArea textAreaPay = new JTextArea();
	JTextArea textAreaCalender = new JTextArea();
	JTextArea textAreaDialog = new JTextArea();
	JTextArea textAreaList = new JTextArea();
	JScrollPane scrollPaneList = new JScrollPane(textAreaList);
	JScrollPane scrollPanePay = new JScrollPane(textAreaPay);
	JScrollPane scrollPaneDialog = new JScrollPane(textAreaDialog);

	// JOptionPane
	JOptionPane popup = new JOptionPane();
//	// JCombobox
//	Integer[] month = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
//	Integer[] year = {2022, 2023, 2024, 2025};
//	JComboBox<Integer> comboBox = new JComboBox<Integer>(month);
//	JComboBox<Integer> comboBox2 = new JComboBox<Integer>(year);

	public JFrames() {
		setTitle("일일 알바 관리 프로그램");
		setSize(800, 500);
		setLocationRelativeTo(null);
		init();
		start();
		setVisible(true);
	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("Center", panelCenter);
		container.add("East", panelEast);

		// panelCenter
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add("North", panelTitle);
		panelCenter.add("Center", panelCalender);

		// panelCalender
		panelCalender.setLayout(new GridLayout(7, 7, 5, 5));
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			panelCalender.add(buttons[i]);
			buttons[i].setFont(new Font("Gothic", Font.BOLD, 24));
			buttons[i].setBackground(Color.WHITE);

			if (i < 7)
				buttons[i].setText(dayNames[i]);

			if (i % 7 == 0) { // 일요일 색상
				buttons[i].setForeground(Color.red);
			} else if (i % 7 == 6) { // 토요일 색상
				buttons[i].setForeground(Color.blue);
			}
		}
		// 날짜 출력
		infinityCalender.calSet();

		// panelTitle
		panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelTitle.add(ButtonLast);
		panelTitle.add(Labelmonths);
		panelTitle.add(ButtonNext);

		// panelEast
		panelEast.setLayout(new GridLayout(6, 1));
		panelEast.add(LabelMyList);
		panelEast.add(LabelList);
		panelEast.add(scrollPaneList);
		panelEast.add(ButtonCancel);
		panelEast.add(LabelPay);
		panelEast.add(scrollPanePay);
		textAreaList.setEditable(false);
		textAreaPay.setEditable(false);
		LabelMyList.setHorizontalAlignment(JLabel.CENTER);
		LabelMyList.setFont(font);
		LabelList.setHorizontalAlignment(JLabel.CENTER);
		LabelList.setFont(font);
		LabelPay.setHorizontalAlignment(JLabel.CENTER);
		LabelPay.setFont(font2);
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ButtonCancel.addActionListener(this);
		ButtonLast.addActionListener(this);
		ButtonNext.addActionListener(this);
		// comboBox.addActionListener(this);
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int hour = 3;
		String applyStatus = "신청";
		String approveStatus = "승인";
		ApplyDAO dao = new ApplyDAO();
		ApplyDTO dto = new ApplyDTO(hour, applyStatus, approveStatus);
		if (e.getSource() == ButtonNext) {
			infinityCalender.allinit(1);
			LabelPay.setText("my 알바비 <" + infinityCalender.getCalText2() + infinityCalender.getCalText() + ">");
			Labelmonths.remove(Labelmonths);
			Labelmonths.setText(infinityCalender.getCalText2() + infinityCalender.getCalText());
			for (int i = 0; i < buttons.length; i++) {
				buttons[i].setBackground(Color.WHITE);
			}
		} else if (e.getSource() == ButtonLast) {
			infinityCalender.allinit(-1);
			LabelPay.setText("my 알바비 <" + infinityCalender.getCalText2() + infinityCalender.getCalText() + ">");
			Labelmonths.remove(Labelmonths);
			Labelmonths.setText(infinityCalender.getCalText2() + infinityCalender.getCalText());
		} else
			for (int i = 0; i < buttons.length; i++) {
				if (e.getSource() == buttons[i]) {
					buttons[i].setBackground(Color.GREEN);		// buttons[i]에 색상 지정
					String day = infinityCalender.getCalText2() + infinityCalender.getCalText() +buttons[i].getText() + "일";	// day변수에 날짜 저장
					int result = popup.showConfirmDialog(null, "a", day + "아르바이트 상세 내용", JOptionPane.YES_NO_OPTION);	// result 변수에 yes 클릭시 0저장, no클릭시 1저장
					detail.add(day);			// detail 배열에 day값 저장
					if (result == 0) {
						for(int j = 0; j < detail.size(); j ++) {
							dao.insert(dto);
							textAreaList.setText(detail.get(j).toString() + "a" + "\n");		// textAreaList에 detail 배열값 출력
							textAreaList.append("---------------------" + "\n");
							for(int a = 0; a<j; a++) {
								textAreaList.append(detail.get(a).toString() + "a" + "\n");		// textAreaList에 다음 detail 배열값 출력
							}
						}
					} else {
						buttons[i].setBackground(Color.WHITE);		// result 값이 1이면 buttons[i] 배경을 흰색으로
						for(int j = 0; j<detail.size(); j++) {
							textAreaList.setText(detail.get(j).toString() + "a" + "X\n");
							}
						}
					}
				}
			}	
	}

//		} else if(e.getSource() == comboBox) {
//		LabelPay.remove(LabelPay);
//		LabelPay.setText("my 알바비 <" + comboBox.getSelectedItem() + "월>");
//		infinityCalender.allinit((Integer)comboBox.getSelectedItem());
//	} 

public class ApplyFrame {
	public static void main(String[] args) {
		JFrames jFrames = new JFrames();
	}
}
