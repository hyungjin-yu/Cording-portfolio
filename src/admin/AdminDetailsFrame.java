package admin;

import java.awt.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import apply.ApplyDTO;

public class AdminDetailsFrame extends JFrame implements ActionListener {
	Container container = getContentPane();
	
	// Panel
	JPanel panelDate = new JPanel();		// ��¥
	JPanel panelJobDetails = new JPanel();	// �ϴ� �� ������
	JPanel panelEditDelete = new JPanel();	// ����, ���� �г�
	JPanel panelListTitle = new JPanel();	// ����Ʈ ���� ("��û�� ���")
	JPanel panelList = new JPanel();		// ����Ʈ ��ü
	JPanel panelListInner = new JPanel();	// ����Ʈ ��ü
	JPanel[] panels = null;					// ����Ʈ �迭
	JPanel panelButton = new JPanel();				// ����, �ź� ��ư ����

	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
	JScrollPane scrollPane = new JScrollPane(panelList);
	
	JPanel panelTime = new JPanel();
	JPanel panelLoc = new JPanel();
	JPanel panelJob = new JPanel();
	JPanel panelDetails = new JPanel();
	JPanel panelWage = new JPanel();
	JPanel panelPayday = new JPanel();
	
	// Label
	JLabel labelDate = new JLabel("��¥");
	JLabel labelTime_ = new JLabel("�ð� : ");
	JLabel labelLoc_ = new JLabel("��ġ : ");
	JLabel labelJob_ = new JLabel("�ϴ� �� : ");
	JLabel labelDetails_ = new JLabel("���γ��� : ");
	JLabel labelWage_ = new JLabel("�ñ� : ");
	JLabel labelPayday_ = new JLabel("������ : ");
	
	JLabel labelTime = new JLabel();
	JLabel labelLoc = new JLabel();
	JLabel labelJob = new JLabel();
	JLabel labelDetails = new JLabel();
	JLabel labelWage = new JLabel();
	JLabel labelPayday = new JLabel();
	
	JLabel labelListTitle = new JLabel("��û�� ���");
	JLabel labelAlba = null;	// ����Ʈ �迭 �ȿ� �� ��
	
	// Button
	RoundedButton buttonEdit = new RoundedButton("����");
	RoundedButton buttonDelete = new RoundedButton("����");
	
	RoundedButton[] buttonApprove = null;
	RoundedButton[] buttonReject = null;
	
	// Border
	Border border = BorderFactory.createLineBorder(new Color(255, 221, 219), 3);
	
	//DB
	AdminDAO dao = new AdminDAO();
	List<AdminDTO> adminList = new ArrayList<AdminDTO>();
	
	List<ApplyDTO> applyList = new ArrayList<ApplyDTO>();
	
	public AdminDetailsFrame(String date) {
		setTitle("�˹� ������");
		setSize(400, 500);
		setLocationRelativeTo(null);
		init(date);
		start();
		setVisible(true);
		setResizable(false);
	}
	
	private void init(String date) {
		container.setBackground(Color.WHITE);
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(panelDate);
		container.add(panelJobDetails);
		container.add(panelEditDelete);
		container.add(tabbedPane);	// tabbedPane �ȿ� scrollPane �ȿ� panelList
		
		panelDate.setBackground(Color.WHITE);
		panelDate.setLayout(new FlowLayout());
		panelDate.add(labelDate);
		labelDate.setText(date);
		labelDate.setAlignmentX(CENTER_ALIGNMENT);
		labelDate.setFont(new Font("Gothic", Font.BOLD, 20));
		
		// �ϴ� �� ������
		panelJobDetails.setBackground(Color.WHITE);
		panelJobDetails.setLayout(new GridLayout(6, 1));
		panelJobDetails.add(panelTime);
		panelJobDetails.add(panelLoc);
		panelJobDetails.add(panelJob);
		panelJobDetails.add(panelDetails);
		panelJobDetails.add(panelWage);
		panelJobDetails.add(panelPayday);
		panelJobDetails.setAlignmentX(panelJobDetails.CENTER_ALIGNMENT);
		panelJobDetails.setBorder(new CompoundBorder(new EmptyBorder(10,30,10,30), border));
		
		// �˹� ������ ����Ʈ
		adminList = dao.adminList(labelDate.getText());
		
		// panelTime
		panelTime.setBackground(Color.WHITE);
		panelTime.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelTime.add(labelTime_);
		panelTime.add(labelTime);
		labelTime.setText(adminList.get(0).getTime1()+":00 ~ "+adminList.get(0).getTime2()+":00");
		// panelLoc
		panelLoc.setBackground(Color.WHITE);
		panelLoc.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelLoc.add(labelLoc_);
		panelLoc.add(labelLoc);
		labelLoc.setText(adminList.get(0).getLoc());
		// panelJob
		panelJob.setBackground(Color.WHITE);
		panelJob.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelJob.add(labelJob_);
		panelJob.add(labelJob);
		labelJob.setText(adminList.get(0).getJob());
		// panelDetails
		panelDetails.setBackground(Color.WHITE);
		panelDetails.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelDetails.add(labelDetails_);
		panelDetails.add(labelDetails);
		labelDetails.setText(adminList.get(0).getDetails());
		// panelHWage
		panelWage.setBackground(Color.WHITE);
		panelWage.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelWage.add(labelWage_);
		panelWage.add(labelWage);
		labelWage.setText(Integer.toString(adminList.get(0).getWage())+"��");
		// panelPayday
		panelPayday.setBackground(Color.WHITE);
		panelPayday.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelPayday.add(labelPayday_);
		panelPayday.add(labelPayday);
		labelPayday.setText(adminList.get(0).getPayday());
		
		// panelEditDelete
		panelEditDelete.setBackground(Color.WHITE);
		panelEditDelete.setLayout(new FlowLayout());
		panelEditDelete.add(buttonEdit);
		panelEditDelete.add(buttonDelete);
		
		// ��û�� ��� tabbedPane
		tabbedPane.add("��û�� ���", scrollPane);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		scrollPane.setBackground(Color.WHITE);
		
		// panelList
		panelList.setBackground(Color.WHITE);
		panelList.setLayout(new BoxLayout(panelList, BoxLayout.Y_AXIS));
		panelList.add(panelListInner);
		panelListInner.setBackground(Color.WHITE);
		
		
		// ��û�� ���
		applyList = dao.applyList(labelDate.getText());
		
		// ��û�� ��
		int count = applyList.size();
		panels = new JPanel[count];
		buttonApprove = new RoundedButton[count];
		buttonReject = new RoundedButton[count];
		
		panelListInner.setLayout(new GridLayout(count, 1));
		for(int i=0; i<count; i++) {
			panels[i] = new JPanel();
			panels[i].setBorder(new LineBorder(Color.BLACK));
			panelListInner.add(panels[i]);
			panels[i].setFont(new Font("Gothic", Font.BOLD, 20));
			panels[i].setBackground(Color.WHITE);
			
			panels[i].setLayout(new FlowLayout());
			panels[i].add(new JLabel(applyList.get(i).toString()));
			panelButton = new JPanel();
			panels[i].add(panelButton);
			
			panelButton.setBackground(Color.WHITE);
			panelButton.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
			panelButton.setLayout(new GridLayout(2, 1, 1, 2));
			
			// ��û���� : applyStatus = 0, approveStatus = 0
			// �̽���(�����) : applyStatus = 1, approveStatus = 0
			// ���� : applyStatus = 1, approveStatus = 1
			// ���� : applyStatus = 1, approveStatus = 2
			int a1 = applyList.get(i).getApplyStatus();
			int a2 = applyList.get(i).getApproveStatus();
			if(a1==1 && a2==0) {
				buttonApprove[i] = new RoundedButton("����");
				buttonReject[i] = new RoundedButton("����");
			} else if(a1==1 && a2==1) {
				buttonApprove[i] = new RoundedButton("���οϷ�");
				buttonReject[i] = new RoundedButton("�������");
			} else if(a1==1 && a2==2) {
				buttonApprove[i] = new RoundedButton("������");
				buttonReject[i] = new RoundedButton("�������");
			}
			
			panelButton.add(buttonApprove[i]);
			panelButton.add(buttonReject[i]);
			/*
			buttonApprove.setOpaque(false);
			buttonApprove.setFocusPainted(false);
			buttonApprove.setBorderPainted(false);
			buttonApprove.setContentAreaFilled(false);
			*/
		}
	}
	
	private void start() {
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		buttonEdit.addActionListener(this);
		buttonDelete.addActionListener(this);
		
		for(int i=0; i<panels.length; i++) {
			buttonApprove[i].addActionListener(this);
			buttonReject[i].addActionListener(this);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// �˹� ���� ����
		if(e.getSource() == buttonEdit) {
			int editConfirm = JOptionPane.showConfirmDialog(this, "�˹� ������ �����Ͻðڽ��ϱ�?", "�˹� ���� ����", 
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			switch(editConfirm) {
			case 0:	// OK
				AdminEditFrame arf = new AdminEditFrame(labelDate.getText());
				dispose();
				break;
			case 2:	// CANCEL
				break;
			}
		}
		
		// �˹� ���� ����
		if(e.getSource() == buttonDelete) {
			int deleteConfirm = JOptionPane.showConfirmDialog(this, "�˹� ������ �����Ͻðڽ��ϱ�?", "�˹� ���� ����", 
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			switch(deleteConfirm) {
			case 0:	// OK
				int result = dao.delete(labelDate.getText());
				
				if(result > 0) {
					JOptionPane.showMessageDialog(this, "�����Ǿ����ϴ�.", "MESSAGE", 
							JOptionPane.INFORMATION_MESSAGE);
					dispose();
					
				} else {
					JOptionPane.showMessageDialog(this, "���� �����߽��ϴ�.", "MESSAGE", 
							JOptionPane.WARNING_MESSAGE);
				}
				break;
				
			case 2:	// CANCEL
				break;
			}
		}
		
		// ����, ����
		// ��û���� : applyStatus = 0, approveStatus = 0
		// �̽���(�����) : applyStatus = 1, approveStatus = 0
		// ���� : applyStatus = 1, approveStatus = 1
		// ���� : applyStatus = 1, approveStatus = 2
		for(int i=0; i<panels.length; i++) {
			if(e.getSource() == buttonApprove[i] && buttonApprove[i].getText().equals("����")) {
				// ���� : applyStatus = 1, approveStatus = 1
				int result = dao.status(labelDate.getText(), applyList.get(i).getId(), 1, 1);
				switch(result) {
				case 1: 
					buttonApprove[i].setEnabled(false);
					buttonApprove[i].setText("���οϷ�");
					buttonReject[i].setText("�������");
					break;
				case 0: 
					break;
				}
				
			} else if(e.getSource() == buttonReject[i]) {
				
				if(buttonReject[i].getText().equals("����")) {
					// ���� : applyStatus = 1, approveStatus = 2
					int result = dao.status(labelDate.getText(), applyList.get(i).getId(), 1, 2);
					switch(result) {
					case 1: 
						buttonApprove[i].setEnabled(false);
						buttonApprove[i].setText("������");
						buttonReject[i].setText("�������");
						break;
					case 0: 
						break;
					}
					
				} else if(buttonReject[i].getText().equals("�������") || buttonReject[i].getText().equals("�������")) {
					// �������, ������� : applyStatus = 1, approveStatus = 0 (�ٽ� ��û����)
					int result = dao.status(labelDate.getText(), applyList.get(i).getId(), 1, 0);
					switch(result) {
					case 1: 
						buttonApprove[i].setEnabled(true);
						buttonApprove[i].setText("����");
						buttonReject[i].setText("����");
						break;
					case 0: 
						break;
					}
				}
			}
		}
	}
}

