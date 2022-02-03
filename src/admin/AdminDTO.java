package admin;

public class AdminDTO {
	private String date;	// ��¥
	private int time1;	// ���۽ð�
	private int time2;	// ���ð�
	private String loc;		// ���
	private String job;		// �ϴ� ��
	private String details;	// ���� ����
	private int wage;		// �ñ�
	private String payday;	// ������
	
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
		//return "<html>��¥ : " + date + "<br>�ð� : " + time + "<br>��� : " + loc + "<br>�ϴ� �� : " + job + "<br>���γ��� : " + details
		//		+ "<br>�ñ� : " + wage + "<br>������ : " + payday + "</html>";
		return "��¥ : " + date + "\n���� �ð� : " + time1 + "\n�� �ð� : "  + time2 + "\n��� : " + loc + "\n�ϴ� �� : " + job + "\n���γ��� : " + details
				+ "\n�ñ� : " + wage + "\n������ : " + payday;
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
