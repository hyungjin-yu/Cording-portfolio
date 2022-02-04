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
   JLabel LabelPay = new JLabel("my 알바비 <2022년 2월>"); // 나중에 달력 월 수에 맞게 바꿀 예정
   JLabel Labelmonths = new JLabel("2022년 2월");
   RoundedLabel labelStatus = null;
   JLabel labelJob = null;
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
      setTitle("일일 알바 관리 프로그램");
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
            buttons[i].setText(dayNames[i]);   // 버튼에 요일 출력
            
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
      
      String year = Integer.toString(infinityCalender.year);
      String month = Integer.toString(infinityCalender.month);
      
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
               str = "신청 " + Integer.toString(applyList.size()) + "명";
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
         LabelPay.setText("my 알바비 <" + infinityCalender.getCalText2() + infinityCalender.getCalText() + ">");
         Labelmonths.remove(Labelmonths);
         Labelmonths.setText(infinityCalender.getCalText2() + infinityCalender.getCalText());
         for (int i = 0; i < buttons.length; i++) {
            buttons[i].setBackground(Color.WHITE);
         }
         setLabelJob();
      } else if (e.getSource() == ButtonLast) {
         infinityCalender.allinit(-1);
         LabelPay.setText("my 알바비 <" + infinityCalender.getCalText2() + infinityCalender.getCalText() + ">");
         Labelmonths.remove(Labelmonths);
         Labelmonths.setText(infinityCalender.getCalText2() + infinityCalender.getCalText());
         setLabelJob();
      } else
         for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
               buttons[i].setBackground(Color.GREEN); // buttons[i]에 색상 지정
               String day = infinityCalender.getCalText2() + infinityCalender.getCalText() + buttons[i].getText()
                     + "일"; // day변수에 날짜 저장
               int result = popup.showConfirmDialog(null, "상세 내용 : " + dao.detail(buttons[i].getText()), day + "아르바이트 상세 내용", JOptionPane.YES_NO_OPTION); // result 변수에 yes 클릭시 0저장, no클릭시 1저장
               detail.add(day); // detail 배열에 day값 저장
               System.out.println("아이디 : " + dto.getId());
               if (result == 0) {
                  for (int j = 0; j < detail.size(); j++) {
                     dto.setDate(day);
                     dao.insert(dto);
                     textAreaList.setText(detail.get(j).toString() + "\t" +dao.detail(buttons[i].getText()) + "\n"); // textAreaList에 detail 배열값 출력
                     textAreaList.append("---------------------" + "\n");
                     for (int a = 0; a < j; a++) {
                        textAreaList.append(detail.get(a).toString() + "\t" +dao.detail(buttons[i].getText()) + "\n"); // textAreaList에 다음 detail  배열값 출력
                     }
                  }
               } else {
                  buttons[i].setBackground(Color.WHITE); // result 값이 1이면 buttons[i] 배경을 흰색으로
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
         Color lightPink = new Color(255, 221, 219); // 배경색 결정
         Color lightBlue = new Color(214, 234, 255);
         Color blue = new Color(173, 211, 255);
         Color darkBlue = new Color(148, 201, 255);
         Color o = new Color(54, 54, 54); // 글자색 결정
         int width = (int) (getWidth() * 0.7);
         int height = getHeight();
         Graphics2D graphics = (Graphics2D) g;
         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         if (text.equals("승인완료")) {
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
//      LabelPay.setText("my 알바비 <" + comboBox.getSelectedItem() + "월>");
//      infinityCalender.allinit((Integer)comboBox.getSelectedItem());
//   } 