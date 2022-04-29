package order.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import order.bean.OrderDTO;

@Repository
public class OrderDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 주문 입력
	public int orderInsert(OrderDTO dto) {
		return sqlSession.insert("mybatis.orderMapper.orderInsert", dto);
	}
	
	// 주문 내역 목록
	public List<OrderDTO> getOrderList(int startNum, int endNum, String user_id) {
		String startNum_str = String.format("%d", startNum);
		String endNum_str = String.format("%d", endNum);
		Map<String, String> map = new HashMap<String, String>();
		map.put("startNum", startNum_str);
		map.put("endNum", endNum_str);
		map.put("user_id", user_id);
		
		return sqlSession.selectList("mybatis.orderMapper.getOrderList", map);
	}
	
	// 총 데이터 개수 구하기
	public int getTotalA(String user_id) {
		return sqlSession.selectOne("mybatis.orderMapper.getTotalA", user_id);
	}
	
	// 상세 주문 내역
	public OrderDTO getOrderDetail(String ord_number) {
		return sqlSession.selectOne("mybatis.orderMapper.getOrderDetail", ord_number);
	}
}
