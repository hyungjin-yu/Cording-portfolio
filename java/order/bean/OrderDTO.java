package order.bean;

public class OrderDTO {
	private String ord_date; 		// 주문 날짜
	private int ord_number; 		// 주문 번호(시퀀스)
	private String ord_code; 		// 상품 번호
	private String ord_name; 		// 상품 이름
	private String ord_color; 		// 색상
	private String ord_size; 		// 사이즈
	private String ord_image;		// 상품 이미지
	private int ord_price; 			// 상품 개별 금액
	private int ord_qty; 			// 상품 개수
	private int ord_totalprice; 	// total 금액
	private String user_id; 		// 회원 id
	private String user_name; 		// 구매자 이름
	private String ord_addr1; 		// 주소
	private String ord_addr2; 		// 상세주소
	private String ord_phone; 		// 전화번호
	private String ord_payment; 	// 결제 수단

	// getter / setter
	public String getOrd_date() {
		return ord_date;
	}
	public void setOrd_date(String ord_date) {
		this.ord_date = ord_date;
	}
	public int getOrd_number() {
		return ord_number;
	}
	public void setOrd_number(int ord_number) {
		this.ord_number = ord_number;
	}
	public String getOrd_code() {
		return ord_code;
	}
	public void setOrd_code(String ord_code) {
		this.ord_code = ord_code;
	}
	public String getOrd_name() {
		return ord_name;
	}
	public void setOrd_name(String ord_name) {
		this.ord_name = ord_name;
	}
	public String getOrd_color() {
		return ord_color;
	}
	public void setOrd_color(String ord_color) {
		this.ord_color = ord_color;
	}
	public String getOrd_size() {
		return ord_size;
	}
	public void setOrd_size(String ord_size) {
		this.ord_size = ord_size;
	}
	public String getOrd_image() {
		return ord_image;
	}
	public void setOrd_image(String ord_image) {
		this.ord_image = ord_image;
	}
	public int getOrd_price() {
		return ord_price;
	}
	public void setOrd_price(int ord_price) {
		this.ord_price = ord_price;
	}
	public int getOrd_qty() {
		return ord_qty;
	}
	public void setOrd_qty(int ord_qty) {
		this.ord_qty = ord_qty;
	}
	public int getOrd_totalprice() {
		return ord_totalprice;
	}
	public void setOrd_totalprice(int ord_totalprice) {
		this.ord_totalprice = ord_totalprice;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getOrd_addr1() {
		return ord_addr1;
	}
	public void setOrd_addr1(String ord_addr1) {
		this.ord_addr1 = ord_addr1;
	}
	public String getOrd_addr2() {
		return ord_addr2;
	}
	public void setOrd_addr2(String ord_addr2) {
		this.ord_addr2 = ord_addr2;
	}
	public String getOrd_phone() {
		return ord_phone;
	}
	public void setOrd_phone(String ord_phone) {
		this.ord_phone = ord_phone;
	}
	public String getOrd_payment() {
		return ord_payment;
	}
	public void setOrd_payment(String ord_payment) {
		this.ord_payment = ord_payment;
	}
}
