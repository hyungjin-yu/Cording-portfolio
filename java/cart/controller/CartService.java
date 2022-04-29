package cart.controller;

import java.util.List;

import cart.bean.CartDTO;

public interface CartService {
	public List<CartDTO> getCartList(int startNum, int endNum, String user_id);
	public CartDTO getCartDetail(int cart_seq);
	public int getTotalA(String user_id);
	public int getTotalprice(String user_id);
	public int insertCart(CartDTO dto);
	public int modifyCart(int cart_qty, int cart_totalprice, int cart_seq);
	public int deleteCart(int cart_seq);
	public List<CartDTO> getCartListOrder(String user_id);
}
