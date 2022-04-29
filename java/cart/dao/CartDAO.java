package cart.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cart.bean.CartDTO;

@Repository
public class CartDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/* 목록보기 */
	public List<CartDTO> getCartList(int startNum, int endNum, String user_id) {
		String startNum_str = String.format("%d", startNum);
		String endNum_str = String.format("%d", endNum);
		Map<String, String> map = new HashMap<String, String>();
		map.put("startNum", startNum_str);
		map.put("endNum", endNum_str);
		map.put("user_id", user_id);
		
		return sqlSession.selectList("mybatis.cartMapper.getCartList", map);
	}
	
	/* 특정 상품 데이터 1줄 가져오기 */
	public CartDTO getCartDetail(int cart_seq) {
		return sqlSession.selectOne("mybatis.cartMapper.getCartDetail", cart_seq);
	}
		
	/* 장바구니 개수 */
	public int getTotalA(String user_id) {
		return sqlSession.selectOne("mybatis.cartMapper.getTotalA", user_id);
	}
	
	/* 장바구니 총 상품 금액 */
	public int getTotalprice(String user_id) {
		return sqlSession.selectOne("mybatis.cartMapper.getTotalprice", user_id);
	}
	
	/* 장바구니 등록 */
	public int insertCart(CartDTO dto) {
		return sqlSession.insert("mybatis.cartMapper.insertCart", dto);
	}
	
	/* 옵션 변경 */
	public int modifyCart(int cart_qty, int cart_totalprice, int cart_seq) {
		Map<String, Integer> map = new HashMap<String, Integer>();		
		map.put("cart_qty", cart_qty);
		map.put("cart_totalprice", cart_totalprice);
		map.put("cart_seq", cart_seq);
		
		return sqlSession.update("mybatis.cartMapper.modifyCart", map);
	}
	
	/* 삭제 */
	public int deleteCart(int cart_seq) {
		return sqlSession.delete("mybatis.cartMapper.deleteCart", cart_seq);
	}
	
	/* 특정 회원의 주문할 장바구니 상품 목록 가져오기 */
	public List<CartDTO> getCartListOrder(String user_id) {
		return sqlSession.selectList("mybatis.cartMapper.getCartListOrder", user_id);
	}
}
