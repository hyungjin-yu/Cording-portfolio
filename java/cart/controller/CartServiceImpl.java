package cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cart.bean.CartDTO;
import cart.dao.CartDAO;

@Service("cartService")
public class CartServiceImpl implements CartService {
	@Autowired
	private CartDAO dao;
	
	@Override
	public List<CartDTO> getCartList(int startNum, int endNum, String user_id) {
		return dao.getCartList(startNum, endNum, user_id);
	}
	
	@Override
	public CartDTO getCartDetail(int cart_seq) {
		return dao.getCartDetail(cart_seq);
	}

	@Override
	public int getTotalA(String user_id) {
		return dao.getTotalA(user_id);
	}
	
	@Override
	public int getTotalprice(String user_id) {
		return dao.getTotalprice(user_id);
	}
	
	@Override
	public int insertCart(CartDTO dto) {
		return dao.insertCart(dto);
	}

	@Override
	public int modifyCart(int cart_qty, int cart_totalprice, int cart_seq) {
		return dao.modifyCart(cart_qty, cart_totalprice, cart_seq);
	}

	@Override
	public int deleteCart(int cart_seq) {
		return dao.deleteCart(cart_seq);
	}

	@Override
	public List<CartDTO> getCartListOrder(String user_id) {
		return dao.getCartListOrder(user_id);
	}

}
