package admin;

public class AdminDTO {
	private String date;	// 날짜
	private int time1;	// 시작시간
	private int time2;	// 끝시간
	private String loc;		// 장소
	private String job;		// 하는 일
	private String details;	// 세부 내용
	private int wage;		// 시급
	private String payday;	// 지급일
	
	public AdminDTO() {
		super();
	}
	
	public AdminDTO(String date) {
		super();
		this.date = date;
	}
	
	public AdminDTO(String date, int time1, int time2, String loc, String job, String details, int wage, String payday) {
		super();
		this.date = date;
		this.time1 = time1;
		this.time2 = time2;
		this.loc = loc;
		this.job = job;
		this.details = details;
		this.wage = wage;
		this.payday = payday;
	}
	
	@Override
	public String toString() {
		//return "<html>날짜 : " + date + "<br>시간 : " + time + "<br>장소 : " + loc + "<br>하는 일 : " + job + "<br>세부내용 : " + details
		//		+ "<br>시급 : " + wage + "<br>지급일 : " + payday + "</html>";
		return "날짜 : " + date + "\n시작 시간 : " + time1 + "\n끝 시간 : "  + time2 + "\n장소 : " + loc + "\n하는 일 : " + job + "\n세부내용 : " + details
				+ "\n시급 : " + wage + "\n지급일 : " + payday;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getTime1() {
		return time1;
	}

	public void setTime1(int time1) {
		this.time1 = time1;
	}

	public int getTime2() {
		return time2;
	}

	public void setTime2(int time2) {
		this.time2 = time2;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getWage() {
		return wage;
	}

	public void setWage(int wage) {
		this.wage = wage;
	}

	public String getPayday() {
		return payday;
	}

	public void setPayday(String payday) {
		this.payday = payday;
	}
	
	
	
}
