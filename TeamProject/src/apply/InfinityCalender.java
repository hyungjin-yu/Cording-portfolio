package apply;

import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.JButton;

public class InfinityCalender{
	JButton[] buttons;
	Calendar calendar;
	int year, month, dd;

	public InfinityCalender(JButton[] buttons) {
		this.buttons = buttons;
		calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
		dd = calendar.get(Calendar.DATE);
	}

	// Label�� ����� ���ڿ�
	public String getCalText() {
		return  month + "��";
	}
	
	public String getCalText2() {
		return  year + "��";
	}
	
	public String getCalText3() {
		return  dd + "��";
	}
	
	public void calSet() {
		// ����� ����
		calendar.set(year, month - 1, 1);
		int firstDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		for (int i = 1; i <= calendar.getActualMaximum(calendar.DATE); i++) {
			buttons[6 + firstDay + i].setText(String.valueOf(i));
		}

	}

	public void allinit(int gap) {
		// ��ư�� ��¥ �����
		for (int i = 7; i < buttons.length; i++) {
			buttons[i].setText("");
		}
		month += gap;
		if (month <= 0) {
			month = 12;
			year--;
		} else if (month >= 13) {
			month = 1;
			year++;
		}
		// ��ư�� ��¥ ����ϱ�
		calSet();
	}
}
