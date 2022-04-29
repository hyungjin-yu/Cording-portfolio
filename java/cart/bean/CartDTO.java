package cart.bean;

/* 장바구니 테이블 */
public class CartDTO {
	private String user_id;			//회원id
	private int cart_seq;			//시퀀스
	private String item_code;		//상품번호
	private String item_name;		//상품이름
	private String item_color;		//색상
	private String item_size;		//사이즈
	private String item_image;		//상품이미지
	private int item_price;			//상품 개별적인 금액
	private int cart_qty;			//상품개수
	private int cart_totalprice;	//total금액
	
	// toString
	@Override
	public String toString() {
		String str = String.format("%s\t%d\t%s\t%s\t%s\t%s\t%d\t%d\t%d", 
							user_id, cart_seq, item_code, item_name, item_color, 
							item_size, item_image, item_price, cart_qty, cart_totalprice);
		return str;
	}
	
	// getter / setter
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public String getItem_image() {
		return item_image;
	}
	public void setItem_image(String item_image) {
		this.item_image = item_image;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public int getCart_qty() {
		return cart_qty;
	}
	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}
	public int getCart_totalprice() {
		return cart_totalprice;
	}
	public void setCart_totalprice(int cart_totalprice) {
		this.cart_totalprice = cart_totalprice;
	}
}