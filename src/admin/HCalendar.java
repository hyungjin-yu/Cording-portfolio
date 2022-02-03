package admin;

import java.util.Calendar;

import javax.swing.JButton;

public class HCalendar {
	JButton[] buttons;
	Calendar calendar;
	int year, month;
	
	public HCalendar(JButton[] buttons) {
		this.buttons = buttons;
		calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
	}
	
	// Label에 출력할 문자열
	public String getCalText() {
		return year + "년 " + month + "월";
	}
	
	// 버튼에 날짜 출력하기
	// 그 달 1일의 요일 수
	public void calSet() {
		// 년월일 설정
		calendar.set(year, month-1, 1);
		// 요일수 구하기
		// => 일:1, 토:7
		// 배열은 0부터 시작이기 때문에, (요일수 -1)을 사용
		int firstDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		for(int i=1; i<=calendar.getActualMaximum(Calendar.DATE); i++) {
			// buttons[0]~[6] : 일~토 문자열이 사용되어짐
			// 그 달의 1일은 buttons[6 + (요일수-1) + i] => buttons[6 + firstDay + i]
			buttons[6 + firstDay + i].setText(String.valueOf(i));
		}
		
	}
	
	// 달력에 새로운 년월로 새로 그리기
	// => before, after 버튼 클릭시 동작
	public void allInit(int gap) {
		// 버튼의 날짜 지우기
		for(int i=7; i<buttons.length; i++) {
			buttons[i].setText("");
		}
		
		// 년월 수정
		month += gap;
		if(month <= 0) {
			month = 12;
			year--;
		} else if(month >= 13) {
			month = 1;
			year++;
		}
		
		// 버튼에 날짜 출력하기
		calSet();
	}
	
}
