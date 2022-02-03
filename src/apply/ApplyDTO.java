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
	private int applyStatus;
	private int approveStatus;
	private String address;
	private String phone;
	
	public ApplyDTO() {
		super();
	}
	
	public ApplyDTO(String id) {
		super();
		this.id = id;
	}
	
	public ApplyDTO(String date, String name, String id, String address, String phone, int applyStatus, int approveStatus) {
		super();
		this.name = name;
		this.id = id;
		this.date = date;
		this.applyStatus = applyStatus;
		this.approveStatus = approveStatus;
	}

	public ApplyDTO(int hour, String address, String phone, int applyStatus, int approveStatus) {
		super();
		this.hour = hour;
		this.address = address;
		this.phone = phone;
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

	public int getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(int applyStatus) {
		this.applyStatus = applyStatus;
	}

	public int getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(int approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
}
