package order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import order.bean.OrderDTO;
import order.dao.OrderDAO;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO dao;
	
	@Override
	public int order_info(OrderDTO dto) {
		return dao.order_info(dto);
	}

	@Override
	public OrderDTO order_check(int seq) {
		return dao.order_check(seq);
	}

}
