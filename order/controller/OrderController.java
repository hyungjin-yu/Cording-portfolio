package order.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import order.bean.OrderDTO;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/item/order_info.do")
	public  ModelAndView order_info(HttpServletRequest request) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		
		OrderDTO dto = new OrderDTO();
		dto.setOrd_date(request.getParameter("ord_date"));
		dto.setOrd_time(request.getParameter("ord_time"));
		dto.setOrd_number(request.getParameter("ord_number"));
		dto.setUser_id(request.getParameter("user_id"));
		dto.setItem_name(request.getParameter("item_name"));
		dto.setItem_image1(request.getParameter("item_image1"));
		dto.setItem_color(request.getParameter("item_color"));
		dto.setItem_size(request.getParameter("item_size"));
		dto.setItem_price(Integer.parseInt(request.getParameter("item_price")));
		dto.setOrd_qty(Integer.parseInt(request.getParameter("ord_qty")));
		dto.setOrd_totalprice(Integer.parseInt(request.getParameter("ord_totalprice")));
		dto.setUser_post(request.getParameter("user_post"));
		dto.setUser_addr1(request.getParameter("user_addr1"));
		dto.setUser_addr2(request.getParameter("user_addr2"));
		
		int result = orderService.order_info(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("req", "../item/order_info.jsp");
		modelAndView.setViewName("Index.jsp");
		
		return modelAndView;
	}
	
	// 주문 확인
	@RequestMapping(value = "/item/order_check.do")
	public ModelAndView order_check(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		OrderDTO dto = orderService.order_check(seq);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("req", "../item/order_check.jsp");

		modelAndView.setViewName("index.jsp");
		return modelAndView;
	}
}
