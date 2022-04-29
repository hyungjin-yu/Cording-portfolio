package order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import item.bean.ItemDTO;
import item.controller.ItemService;
import order.bean.OrderDTO;
import profile.bean.ProfileDTO;
import profile.controller.ProfileService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ProfileService profileService;
	
	// 주문 정보 페이지 이동 : 바로구매
	@RequestMapping(value = "/item/order_info_buynow.do")
	public  ModelAndView order_info(HttpServletRequest request) throws Exception{
		/* 데이터값 넘기기 */
		request.setCharacterEncoding("utf-8");
		
		String item_code = request.getParameter("item_code");
		int item_qty = Integer.parseInt(request.getParameter("item_qty"));
		// 제품 정보 가져오기 : 리스트
		List<ItemDTO> list = itemService.itemViewList(item_code);
		// 회원 정보 가져오기
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("login_id");
		
		ProfileDTO user_dto = profileService.getMember(user_id);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list_now", list);
		modelAndView.addObject("user_dto", user_dto);
		modelAndView.addObject("item_qty", item_qty);
		modelAndView.addObject("req", "../item/order_info.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	// 주문 확인
	@RequestMapping(value = "/item/order_check.do")
	public ModelAndView order_check(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String item_code = request.getParameter("item_code");
		
		//System.out.println("item_code = " + item_code);
		
		int item_qty = Integer.parseInt(request.getParameter("item_qty"));
		String ord_payment = request.getParameter("ord_payment");
		
		// 제품 정보 가져오기
		ItemDTO dto = itemService.itemView(item_code);
		
		// 회원 정보 가져오기
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("login_id");
				
		ProfileDTO user_dto = profileService.getMember(user_id);
		
		// DB 입력
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setOrd_code(item_code);
		orderDTO.setOrd_name(dto.getItem_name());
		orderDTO.setOrd_color(dto.getItem_color());
		orderDTO.setOrd_size(dto.getItem_size());
		orderDTO.setOrd_image(dto.getItem_image1());
		orderDTO.setOrd_price(dto.getItem_price());
		orderDTO.setOrd_qty(item_qty);
		orderDTO.setOrd_totalprice(item_qty*dto.getItem_price());
		orderDTO.setUser_id(user_id);
		orderDTO.setUser_name(user_dto.getUser_name());
		orderDTO.setOrd_addr1(user_dto.getUser_addr1());
		orderDTO.setOrd_addr2(user_dto.getUser_addr2());
		orderDTO.setOrd_payment(ord_payment);
		
		int result = orderService.orderInsert(orderDTO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("../item/order_check.jsp");
		
		return modelAndView;
	}
	
	// 주문 내역
	@RequestMapping(value="/orderlist/orderlist.do")
	public ModelAndView orderlist(HttpServletRequest request, HttpServletResponse response) {
		/* 데이터 처리 */
		int pg = 1;
		if(request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("login_id");
		
		int totalA = orderService.getTotalA(user_id);				//특정 회원의 장바구니 상품 수
		int totalP = (totalA + 2) / 3;
		if(pg > totalP) pg = totalP;
		
		// 목록 보기
		int endNum = pg * 3;
		int startNum = endNum - 2;
		
		// 특정 회원의 주문 내역 리스트 가져오기
		List<OrderDTO> list = orderService.getOrderList(startNum, endNum, user_id);
				
		// 3블럭
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if(endPage > totalP) endPage = totalP;
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("req", "../orderlist/orderlist.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	// 주문 상세 내역
	@RequestMapping(value="/orderlist/orderdetail.do")
	public ModelAndView orderDetail(HttpServletRequest request, HttpServletResponse response) {
		/* 데이터 처리 */
		String ord_number = request.getParameter("ord_number");
		
		OrderDTO dto = orderService.getOrderDetail(ord_number);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("req", "../orderlist/orderdetails.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
}
