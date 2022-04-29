package inquiry.bean;

/* 문의 테이블 */
public class InquiryDTO {
	private int inquiry_code;			//문의글 번호
	private String user_id;				//회원 id
	private String item_code;			//상품 번호
	private String inquiry_subject;		//제목
	private String inquiry_content;		//내용
	private int re_ref;					//관련 글 번호
	private int re_lev;					//답글 레벨
	private int re_seq;					//관련 글 중 출력순서
	private int inquiry_readcount;		//조회수
	private String inquiry_date;		//작성일
	
	//toString
	@Override
	public String toString() {
		String str = String.format("%d\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t%d\t%s",
								inquiry_code, user_id, item_code, inquiry_subject, inquiry_content,
								re_ref, re_lev, re_seq, inquiry_readcount, inquiry_date);
		return str;
	}
	
	// getter / setter
	public int getInquiry_code() {
		return inquiry_code;
	}
	public void setInquiry_code(int inquiry_code) {
		this.inquiry_code = inquiry_code;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getInquiry_subject() {
		return inquiry_subject;
	}
	public void setInquiry_subject(String inquiry_subject) {
		this.inquiry_subject = inquiry_subject;
	}
	public String getInquiry_content() {
		return inquiry_content;
	}
	public void setInquiry_content(String inquiry_content) {
		this.inquiry_content = inquiry_content;
	}
	public int getRe_ref() {
		return re_ref;
	}
	public void setRe_ref(int re_ref) {
		this.re_ref = re_ref;
	}
	public int getRe_lev() {
		return re_lev;
	}
	public void setRe_lev(int re_lev) {
		this.re_lev = re_lev;
	}
	public int getRe_seq() {
		return re_seq;
	}
	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}
	public int getInquiry_readcount() {
		return inquiry_readcount;
	}
	public void setInquiry_readcount(int inquiry_readcount) {
		this.inquiry_readcount = inquiry_readcount;
	}
	public String getInquiry_date() {
		return inquiry_date;
	}
	public void setInquiry_date(String inquiry_date) {
		this.inquiry_date = inquiry_date;
	}
}
