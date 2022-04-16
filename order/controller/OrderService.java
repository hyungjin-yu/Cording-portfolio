package order.controller;

import order.bean.OrderDTO;

public interface OrderService {
	public int order_info(OrderDTO dto);
	public OrderDTO order_check(int seq);
}
