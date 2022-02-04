package apply;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.metal.MetalButtonUI;
import javax.swing.text.AttributeSet.ColorAttribute;

import admin.AdminDAO;
import admin.AdminDTO;

public class ApplyFrame extends JFrame implements ActionListener {
   List<String> detail = new ArrayList<String>();
   Container container = getContentPane();
   //List<AdminDTO> workdaysList = new ArrayList<AdminDTO>();
    //workdaysList = adminDAO.allWorkdays();

   // JPanel
   JPanel panelCenter = new JPanel();
   JPanel panelEast = new JPanel();
   JPanel panelCalender = new JPanel();
   JPanel panelTitle = new JPanel();
   JPanel panelDialog = new JPanel();

   // JButton
   JButton ButtonCancel = new JButton("��û���");
   JButton ButtonNext = new JButton(">");
   JButton ButtonLast = new JButton("<");
   JButton[] buttons = new JButton[49];
   String[] dayNames = { "��", "��", "ȭ", "��", "��", "��", "��" };
   InfinityCalender infinityCalender = new InfinityCalender(buttons);

   // JLabel
   JLabel LabelMyList = new JLabel("my �˹ٸ���Ʈ");
   JLabel Labelmonth = new JLabel("��");
   JLabel LabelList = new JLabel("��û���");
   JLabel LabelPay = new JLabel("my �˹ٺ� <2022�� 2��>"); // ���߿� �޷� �� ���� �°� �ٲ� ����
   JLabel Labelmonths = new JLabel("2022�� 2��");
   RoundedLabel labelStatus = null;
   JLabel labelJob = null;
   Font font = new Font("�������", Font.BOLD, 20);
   Font font2 = new Font("�������", Font.BOLD, 10);

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
//   // JCombobox
//   Integer[] month = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
//   Integer[] year = {2022, 2023, 2024, 2025};
//   JComboBox<Integer> comboBox = new JComboBox<Integer>(month);
//   JComboBox<Integer> comboBox2 = new JComboBox<Integer>(year);
   
   // DB
   AdminDAO adminDAO = new AdminDAO();
   List<AdminDTO> adminList = new ArrayList<AdminDTO>();
   List<ApplyDTO> applyList = new ArrayList<ApplyDTO>();
   
   public ApplyFrame(String id) {
      setTitle("���� �˹� ���� ���α׷�");
      setSize(800, 700);
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
         buttons[i].setFont(new Font("Gothic", Font.BOLD, 14));
         buttons[i].setBackground(Color.WHITE);
         buttons[i].setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));      
           buttons[i].setBorderPainted(false);                                 
           buttons[i].setFocusPainted(false);                                    
           buttons[i].setHorizontalAlignment(SwingConstants.LEFT);               
           buttons[i].setVerticalAlignment(SwingConstants.TOP);               
           
           if(i<7) {
            buttons[i].setText(dayNames[i]);   // ��ư�� ���� ���
            
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
         
      // ��¥ ���
      
      infinityCalender.calSet();
      
      setLabelJob();
      
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
   // ��¥ĭ�� job ���
   public void setLabelJob() {
      // labelJob �ʱ�ȭ
      for(int i=0; i<buttons.length; i++) {
         buttons[i].removeAll();
      }
      
      // ��û�� ��¥ ��� ��������
      List<AdminDTO> workdaysList = new ArrayList<AdminDTO>();
      workdaysList = adminDAO.allWorkdays();
      labelJob = new JLabel();
      
      String year = Integer.toString(infinityCalender.year);
      String month = Integer.toString(infinityCalender.month);
      
      for(int i=0; i<buttons.length; i++) {
         String day = buttons[i].getText();
         String date = year + "�� " + month + "�� " + day + "��";
         
         for(int j=0; j<workdaysList.size(); j++) {
            // �̹��޿� ��û�� ��¥ ã��
            if(date.equals(workdaysList.get(j).getDate())) {
               //Ȯ�ο�
               //System.out.println(date+"="+workdaysList.get(j).getDate());
               buttons[i].setLayout(new GridBagLayout());
               
               // labelStatus�� ��û�� �� ���
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
               
               // ��û�� ��¥�� �ϴ��� ���
               adminList = adminDAO.adminList(year + "�� " + month + "�� " + day + "��");
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
               str = "���οϷ�";
               break;
            } else {
               str = "��û " + Integer.toString(applyList.size()) + "��";
            }
         }
      } else {   
      }
      return str;
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
	   AdminDTO ad = new AdminDTO();
	   AdminDAO at = new AdminDAO();
      int hour = ad.getTime2() - ad.getTime2();
      int applyStatus = 1;
      int approveStatus = 1;
      ApplyDAO dao = new ApplyDAO();
      ApplyDTO dto = new ApplyDTO(hour, applyStatus, approveStatus);;
      if (e.getSource() == ButtonNext) {
         infinityCalender.allinit(1);
         LabelPay.setText("my �˹ٺ� <" + infinityCalender.getCalText2() + infinityCalender.getCalText() + ">");
         Labelmonths.remove(Labelmonths);
         Labelmonths.setText(infinityCalender.getCalText2() + infinityCalender.getCalText());
         for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackground(Color.WHITE);
         }
         setLabelJob();
      } else if (e.getSource() == ButtonLast) {
         infinityCalender.allinit(-1);
         LabelPay.setText("my �˹ٺ� <" + infinityCalender.getCalText2() + infinityCalender.getCalText() + ">");
         Labelmonths.remove(Labelmonths);
         Labelmonths.setText(infinityCalender.getCalText2() + infinityCalender.getCalText());
         setLabelJob();
      } else
         for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
               buttons[i].setBackground(Color.GREEN); // buttons[i]�� ���� ����
               String day = infinityCalender.getCalText2() + infinityCalender.getCalText() + buttons[i].getText()
                     + "��"; // day������ ��¥ ����
               int result = popup.showConfirmDialog(null, "�� ���� : " + dao.detail(buttons[i].getText()), day + "�Ƹ�����Ʈ �� ����", JOptionPane.YES_NO_OPTION); // result ������ yes Ŭ���� 0����, noŬ���� 1����
               detail.add(day); // detail �迭�� day�� ����
               System.out.println("���̵� : " + dto.getId());
               if (result == 0) {
                  for (int j = 0; j < detail.size(); j++) {
                     dto.setDate(day);
                     dao.insert(dto);
                     textAreaList.setText(detail.get(j).toString() + "\t" +dao.detail(buttons[i].getText()) + "\n"); // textAreaList�� detail �迭�� ���
                     textAreaList.append("---------------------" + "\n");
                     for (int a = 0; a < j; a++) {
                        textAreaList.append(detail.get(a).toString() + "\t" +dao.detail(buttons[i].getText()) + "\n"); // textAreaList�� ���� detail  �迭�� ���
                     }
                  }
               } else {
                  buttons[i].setBackground(Color.WHITE); // result ���� 1�̸� buttons[i] ����� �������
                  }
               }
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
         Color lightPink = new Color(255, 221, 219); // ���� ����
         Color lightBlue = new Color(214, 234, 255);
         Color blue = new Color(173, 211, 255);
         Color darkBlue = new Color(148, 201, 255);
         Color o = new Color(54, 54, 54); // ���ڻ� ����
         int width = (int) (getWidth() * 0.7);
         int height = getHeight();
         Graphics2D graphics = (Graphics2D) g;
         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         if (text.equals("���οϷ�")) {
            graphics.setColor(lightPink);
         } else if (text.equals("<") || text.equals(">")) {
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

//      } else if(e.getSource() == comboBox) {
//      LabelPay.remove(LabelPay);
//      LabelPay.setText("my �˹ٺ� <" + comboBox.getSelectedItem() + "��>");
//      infinityCalender.allinit((Integer)comboBox.getSelectedItem());
//   } 