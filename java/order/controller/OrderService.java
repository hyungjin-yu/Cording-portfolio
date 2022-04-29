package order.controller;

import java.util.List;

import order.bean.OrderDTO;

public interface OrderService {
	public int orderInsert(OrderDTO dto);
	public List<OrderDTO> getOrderList(int startNum, int endNum, String user_id);
	public int getTotalA(String user_id);
	public OrderDTO getOrderDetail(String ord_number);
}
