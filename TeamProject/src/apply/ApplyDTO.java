package apply;

public class ApplyDTO {
	private String name;
	private String id;
	private String date;
	private String time;
	private String loc;
	private String job;
	private String datails;
	private String wage;
	private String payday;
	private int hour;
	private boolean applyStatus = false;
	private boolean approveStatus = false;
	
	public ApplyDTO() {
		super();
	}

	public ApplyDTO(String name) {
		super();
		this.name = name;
	}

	public ApplyDTO(String date, String time, String loc, String job, String datails, String wage, String payday) {
		super();
		this.date = date;
		this.time = time;
		this.loc = loc;
		this.job = job;
		this.datails = datails;
		this.wage = wage;
		this.payday = payday;
	}

	public ApplyDTO(int hour, boolean applyStatus, boolean approveStatus) {
		super();
		this.hour = hour;
		this.applyStatus = applyStatus;
		this.approveStatus = approveStatus;
	}

	@Override
	public String toString() {
		String str = "일한 시간" +  hour + "\n신청여부" + applyStatus + "\n승인여부" + approveStatus;
		return str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public String getDatails() {
		return datails;
	}

	public void setDatails(String datails) {
		this.datails = datails;
	}

	public String getWage() {
		return wage;
	}

	public void setWage(String wage) {
		this.wage = wage;
	}

	public String getPayday() {
		return payday;
	}

	public void setPayday(String payday) {
		this.payday = payday;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public boolean isApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(boolean applyStatus) {
		this.applyStatus = applyStatus;
	}

	public boolean isApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(boolean approveStatus) {
		this.approveStatus = approveStatus;
	}
	
}
