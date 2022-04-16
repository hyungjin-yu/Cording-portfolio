package order.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import order.bean.OrderDTO;

@Repository
public class OrderDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 주문 정보
	public int order_info(OrderDTO dto) {
		return sqlSession.insert("mybatis.orderMapper.order_info", dto);
	}
	
	// 주문 확인
	public OrderDTO order_check(int seq) {
		return sqlSession.selectOne("mybatis.orderMapper.order_check", seq);
	}
}
