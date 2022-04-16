package item.bean;

public class ItemDTO {
	private String user_id; // 회원 id
	private String item_code; // 상품 번호
	private int item_seq; // 시퀀스
	private String item_category1; // 카테고리1(MEN/WOMEN/KIDS)
	private String item_category2; // 카테고리2(신발/의류/용품)
	private String item_category3; // 카테고리3(러닝, 농구, 축구, 골프 / 자켓, 티셔츠, 후디, 팬츠 / 양말, 모자, 가방, 장갑)
	private String item_name; // 상품 이름
	private String item_image1; // 이미지 1(메인 이미지)
	private String item_image2; // 이미지 2(상세보기 이미지)
	private String item_details; // 설명
	private String item_size; // 사이즈
	private String item_color; // 색상
	private int cart_qty; // 상품개수
	private int item_price; // 상품 개별 금액
	private String item_date; // 상품 등록일

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

	public int getItem_seq() {
		return item_seq;
	}

	public void setItem_seq(int item_seq) {
		this.item_seq = item_seq;
	}

	public String getItem_category1() {
		return item_category1;
	}

	public void setItem_category1(String item_category1) {
		this.item_category1 = item_category1;
	}

	public String getItem_category2() {
		return item_category2;
	}

	public void setItem_category2(String item_category2) {
		this.item_category2 = item_category2;
	}

	public String getItem_category3() {
		return item_category3;
	}

	public void setItem_category3(String item_category3) {
		this.item_category3 = item_category3;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getItem_image1() {
		return item_image1;
	}

	public void setItem_image1(String item_image1) {
		this.item_image1 = item_image1;
	}

	public String getItem_image2() {
		return item_image2;
	}

	public void setItem_image2(String item_image2) {
		this.item_image2 = item_image2;
	}

	public String getItem_details() {
		return item_details;
	}

	public void setItem_details(String item_details) {
		this.item_details = item_details;
	}

	public String getItem_size() {
		return item_size;
	}

	public void setItem_size(String item_size) {
		this.item_size = item_size;
	}

	public String getItem_color() {
		return item_color;
	}

	public void setItem_color(String item_color) {
		this.item_color = item_color;
	}

	public int getCart_qty() {
		return cart_qty;
	}

	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}

	public int getItem_price() {
		return item_price;
	}

	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}

	public String getItem_date() {
		return item_date;
	}

	public void setItem_date(String item_date) {
		this.item_date = item_date;
	}

}
