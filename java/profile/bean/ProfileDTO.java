package profile.bean;

public class ProfileDTO {
	private String user_id; // 아이디
	private String user_pwd; // 비밀번호
	private String user_name; // 이름
	private String user_phone; // 전화번호
	private String user_email; // 이메일
	private String user_addr1; // 주소
	private String user_addr2; // 상세주소
	private String user_gender; // 성별
	private String user_birth; // 생년월일
	private String user_joindate; // 가입일
	
	
	@Override
	public String toString() {
		return "ProfileDTO [user_id=" + user_id + ", user_pwd=" + user_pwd + ", user_name=" + user_name
				+ ", user_phone=" + user_phone + ", user_email=" + user_email + ", user_addr1=" + user_addr1
				+ ", user_addr2=" + user_addr2 + ", user_gender=" + user_gender + ", user_birth=" + user_birth
				+ ", user_joindate=" + user_joindate + "]";
	}
	
	//getter and setter
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_addr1() {
		return user_addr1;
	}
	public void setUser_addr1(String user_addr1) {
		this.user_addr1 = user_addr1;
	}
	public String getUser_addr2() {
		return user_addr2;
	}
	public void setUser_addr2(String user_addr2) {
		this.user_addr2 = user_addr2;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_birth() {
		return user_birth;
	}
	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}
	public String getUser_joindate() {
		return user_joindate;
	}
	public void setUser_joindate(String user_joindate) {
		this.user_joindate = user_joindate;
	}

	
}
