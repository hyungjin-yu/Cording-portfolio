package order.bean;

public class OrderDTO {
	private String ord_date; // 주문 날짜
	private String ord_time; // 주문 날짜
	private String ord_number; // 주문 날짜
	private String user_id; // 회원 id
	private String user_name; // 구매자 이름
	private int cart_seq; // 시퀀스
	private String item_code; // 상품 번호
	private String item_name; // 상품 이름
	private String item_image1; // 이미지 1(메인 이미지)
	private String item_color; // 색상
	private String item_size; // 사이즈
	private int item_price; // 상품 개별 금액
	private int ord_qty; // 상품 개수
	private int ord_totalprice; // total 금액
	private String user_post; // 우편번호
	private String user_addr1; // 주소
	private String user_addr2; // 상세주소
	private String ord_payment; // 결제 수단

	public String getItem_image1() {
		return item_image1;
	}

	public void setItem_image1(String item_image1) {
		this.item_image1 = item_image1;
	}

	public String getOrd_date() {
		return ord_date;
	}

	public void setOrd_date(String ord_date) {
		this.ord_date = ord_date;
	}

	public String getOrd_time() {
		return ord_time;
	}

	public void setOrd_time(String ord_time) {
		this.ord_time = ord_time;
	}

	public String getOrd_number() {
		return ord_number;
	}

	public void setOrd_number(String ord_number) {
		this.ord_number = ord_number;
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

	public int getCart_seq() {
		return cart_seq;
	}

	public void setCart_seq(int cart_seq) {
		this.cart_seq = cart_seq;
	}

	public String getItem_code() {
		return item_code;
	}

	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_color() {
		return item_color;
	}

	public void setItem_color(String item_color) {
		this.item_color = item_color;
	}

	public String getItem_size() {
		return item_size;
	}

	public void setItem_size(String item_size) {
		this.item_size = item_size;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
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

	public String getUser_post() {
		return user_post;
	}

	public void setUser_post(String user_post) {
		this.user_post = user_post;
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

	public String getOrd_payment() {
		return ord_payment;
	}

	public void setOrd_payment(String ord_payment) {
		this.ord_payment = ord_payment;
	}

}
