package notice.bean;

public class NoticeDTO {
	private int notice_seq;			// 공지글 번호(시퀀스)
	private String notice_date;		// 공지 업데이트 날짜(등록일)
	private String notice_title;	// 공지 제목
	private String notice_content;	// 공지 내용
	
	@Override
	public String toString() {
		return "NoticeDTO [notice_seq=" + notice_seq + ", notice_date=" + notice_date + ", notice_title=" + notice_title
				+ ", notice_content=" + notice_content + "]";
	}
	
	public int getNotice_seq() {
		return notice_seq;
	}
	public void setNotice_seq(int notice_seq) {
		this.notice_seq = notice_seq;
	}
	public String getNotice_date() {
		return notice_date;
	}
	public void setNotice_date(String notice_date) {
		this.notice_date = notice_date;
	}
	public String getNotice_title() {
		return notice_title;
	}
	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	
}
