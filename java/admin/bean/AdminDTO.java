package admin.bean;

public class AdminDTO {
	private String admin_id;	// 관리자 아이디
	private String admin_pwd;	// 관리자 비밀번호
	private String admin_name;	// 관리자 이름
	
	@Override
	public String toString() {
		return "AdminDTO [admin_id=" + admin_id + ", admin_pwd=" + admin_pwd + ", admin_name=" + admin_name + "]";
	}
	
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_pwd() {
		return admin_pwd;
	}
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
}
