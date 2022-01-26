package apply;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.BevelBorder;

class JFrames extends JFrame implements ActionListener {
	Container container = getContentPane();

	// JPanel
	JPanel panelCenter = new JPanel();
	JPanel panelEast = new JPanel();
	JPanel panelCalender = new JPanel();
	JPanel panelTitle = new JPanel();
	JPanel panelDialog = new JPanel();

	// JButton
	JButton ButtonList = new JButton("my �˹ٸ���Ʈ");
	JButton ButtonCancel = new JButton("��û���");
	JButton ButtonNext = new JButton(">");
	JButton ButtonLast = new JButton("<");
	JButton ButtonApply = new JButton("��û");
	JButton ButtonClose = new JButton("�ݱ�");
	JButton[] buttons = new JButton[49];
	String[] dayNames = { "��", "��", "ȭ", "��", "��", "��", "��" };
	InfinityCalender infinityCalender = new InfinityCalender(buttons);

	// JLabel
	JLabel Labelmonth = new JLabel("��");
	JLabel LabelList = new JLabel("��û���");
	JLabel LabelPay = new JLabel("my �˹ٺ� <2022�� 1��>"); // ���߿� �޷� �� ���� �°� �ٲ� ����
	JLabel Labelmonths = new JLabel("2022�� 1��");

	// JTextArea
	JTextArea textAreaList = new JTextArea();
	JTextArea textAreaPay = new JTextArea();
	JTextArea textAreaCalender = new JTextArea();
	JTextArea textAreaDialog = new JTextArea();
	JScrollPane scrollPaneList = new JScrollPane(textAreaList);
	JScrollPane scrollPanePay = new JScrollPane(textAreaPay);
	JScrollPane scrollPaneDialog = new JScrollPane(textAreaDialog);

	// JDialog
	JDialog dialog = new JDialog(this, "�󼼳���");
	Container dialogContainer = dialog.getContentPane();
	JLabel dialogLabel = new JLabel("��û�Ǿ����ϴ�.", JLabel.CENTER);

	// JCombobox
	Integer[] month = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
	Integer[] year = { 2022, 2023, 2024, 2025 };
	JComboBox<Integer> comboBox = new JComboBox<Integer>(month);
	JComboBox<Integer> comboBox2 = new JComboBox<Integer>(year);

	// JPopMenu
	JPopupMenu popupMenu = new JPopupMenu();
	JMenuItem menuItem1 = new JMenuItem("���뺸��");

	public JFrames() {
		setTitle("���� �˹� ���� ���α׷�");
		setSize(700, 500);
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

			if (i < 7) {
				buttons[i].setText(dayNames[i]);
			}

			if (i % 7 == 0) { // �Ͽ��� ����
				buttons[i].setForeground(Color.red);
			} else if (i % 7 == 6) { // ����� ����
				buttons[i].setForeground(Color.blue);
			}
		}
		// ��¥ ���
		infinityCalender.calSet();

		// panelTitle
		panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelTitle.add(ButtonLast);
		panelTitle.add(Labelmonths);
		panelTitle.add(ButtonNext);

		// panelEast
		panelEast.setLayout(new GridLayout(6, 1));
		panelEast.add(ButtonList);
		panelEast.add(LabelList);
		panelEast.add(scrollPaneList);
		textAreaList.setEditable(false);
		panelEast.add(ButtonCancel);
		panelEast.add(LabelPay);
		panelEast.add(scrollPanePay);
		textAreaPay.setEditable(false);

		dialog.setSize(200, 150);
		dialog.setLocationRelativeTo(null);
		dialogContainer.setLayout(new BorderLayout());
		dialogContainer.add("Center", scrollPaneDialog);
		textAreaDialog.setEditable(false);
		dialogContainer.add("South", panelDialog);
		dialogLabel.setBorder(new BevelBorder(BevelBorder.RAISED));

		// panelDialog
		panelDialog.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelDialog.add(ButtonApply);
		panelDialog.add(ButtonClose);
	}

	private void start() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		dialog.setDefaultCloseOperation(HIDE_ON_CLOSE);
		ButtonApply.addActionListener(this);
		ButtonCancel.addActionListener(this);
		ButtonClose.addActionListener(this);
		ButtonLast.addActionListener(this);
		ButtonList.addActionListener(this);
		ButtonNext.addActionListener(this);
		comboBox.addActionListener(this);
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ButtonList) {
			dialog.setVisible(true);
		} else if (e.getSource() == ButtonNext) {
			infinityCalender.allinit(1);
			LabelPay.setText("my �˹ٺ� <" + infinityCalender.getCalText2() + infinityCalender.getCalText() + ">");
			Labelmonths.remove(Labelmonths);
			Labelmonths.setText(infinityCalender.getCalText2() + infinityCalender.getCalText());
		} else if (e.getSource() == ButtonLast) {
			infinityCalender.allinit(-1);
			LabelPay.setText("my �˹ٺ� <" + infinityCalender.getCalText2() + infinityCalender.getCalText() + ">");
			Labelmonths.remove(Labelmonths);
			Labelmonths.setText(infinityCalender.getCalText2() + infinityCalender.getCalText());
		} else if (e.getSource() == ButtonApply) {

		} else if (e.getSource() == ButtonCancel) {

		} else if (e.getSource() == comboBox) {
//			LabelPay.remove(LabelPay);
//			LabelPay.setText("my �˹ٺ� <" + comboBox.getSelectedItem() + "��>");
//			infinityCalender.allinit((Integer)comboBox.getSelectedItem());
		} else
			for (int i = 0; i < buttons.length; i++) {
				if (e.getSource() == buttons[i]) {
					buttons[i].setBackground(Color.GREEN);
					JOptionPane popup = new JOptionPane();
					int result = popup.showConfirmDialog(null, "����", "�Ƹ�����Ʈ �� ����", JOptionPane.YES_NO_OPTION);
					if (result == 0) {
						buttons[i].setBackground(Color.GREEN);
					} else {
						buttons[i].setBackground(Color.WHITE);
					}
				}
			}

		ButtonClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();
			}
		});
	}
}

public class ApplyFrame {
	public static void main(String[] args) {
		JFrames jFrames = new JFrames();
	}
}
