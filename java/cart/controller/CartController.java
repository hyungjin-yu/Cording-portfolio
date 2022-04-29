package cart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cart.bean.CartDTO;
import item.bean.ItemDTO;
import item.controller.ItemService;
import order.bean.OrderDTO;
import order.controller.OrderService;
import profile.bean.ProfileDTO;
import profile.controller.ProfileService;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ProfileService profileService;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/item/cartWrite.do")
	public ModelAndView cartWrite(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("진입 성공");
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("login_id");		//login_id의 세션 값 불러오기
		
		String item_code = request.getParameter("item_code");
		ItemDTO item_dto = itemService.itemView(item_code);
		int cart_qty = Integer.parseInt(request.getParameter("item_qty"));
		
		CartDTO dto = new CartDTO();
		dto.setUser_id(user_id);
		dto.setItem_code(item_code);
		dto.setItem_name(item_dto.getItem_name());
		dto.setItem_color(item_dto.getItem_color());
		dto.setItem_size(item_dto.getItem_size());
		dto.setItem_image(item_dto.getItem_image1());
		dto.setItem_price(item_dto.getItem_price());
		dto.setCart_qty(cart_qty);
		dto.setCart_totalprice(dto.getItem_price()*dto.getCart_qty());
		
		int result = cartService.insertCart(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("item_code", item_code);
		modelAndView.addObject("result", result);
		modelAndView.setViewName("../item/cartWrite.jsp");	// 장바구니에 담겼는지 성공 여부
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/item/cartList.do")
	public ModelAndView cartList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/* 데이터 처리 */
		int pg = 1;
		if(request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		// 페이징 처리
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("login_id");		//login_id의 세션 값 불러오기
		int totalA = cartService.getTotalA(user_id);					//특정 회원의 장바구니 상품 수
		int totalP = (totalA + 2) / 3;
		if(pg > totalP) pg = totalP;
		
		// 목록 보기
		int endNum = pg * 3;
		int startNum = endNum - 2;
		
		List<CartDTO> list = cartService.getCartList(startNum, endNum, user_id);	// 특정 회원의 장바구니 목록
		
		// 3블럭
		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;
		if(endPage > totalP) endPage = totalP;
		
		// 총 주문 금액
		int totalPrice = cartService.getTotalprice(user_id);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("totalA", totalA);
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("totalPrice", totalPrice);
		modelAndView.addObject("req", "../item/cartList.jsp");
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/item/cartModify.do")
	public ModelAndView cartListModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/* 데이터 처리 */
		// 수량 수정
		int cart_qty = Integer.parseInt(request.getParameter("cart_qty"));
		int cart_seq = Integer.parseInt(request.getParameter("cart_seq"));
		
		// 특정 상품의 데이터 1줄 가져오기
		CartDTO dto = cartService.getCartDetail(cart_seq);
		int cart_price = dto.getItem_price();
		int cart_totalprice = cart_qty * cart_price;
		
		// 수량 수정
		int result = cartService.modifyCart(cart_qty, cart_totalprice, cart_seq);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("req", "../item/cartModify.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	
	@RequestMapping(value="/item/cartListDelete.do")
	public ModelAndView cartListDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/* 데이터 처리 */
		int cart_seq = Integer.parseInt(request.getParameter("cart_seq"));
		int result = cartService.deleteCart(cart_seq);
			
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("req", "../item/cartListDelete.jsp");
		modelAndView.setViewName("../main/index.jsp");
		return modelAndView;
	}
	
	// 주문 정보 페이지 이동
	@RequestMapping(value="/item/cartOrder.do")
	public ModelAndView cartOrder(HttpServletRequest request, HttpServletResponse response) {
		/* 데이터 처리 */
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("login_id");		//login_id의 세션 값 불러오기
		
		// 특정 회원의 장바구니 리스트 가져오기
		List<CartDTO> list = cartService.getCartListOrder(user_id);
		
		// 특정 회원의 정보 가져오기
		ProfileDTO user_dto = profileService.getMember(user_id);
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("user_dto", user_dto);
		modelAndView.addObject("req", "../item/order_info.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	// 결제 입력
	@RequestMapping(value="/item/cartOrderInsert.do")
	public ModelAndView cartOrderInsert(HttpServletRequest request, HttpServletResponse response) {
		/* 데이터 처리 */
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("login_id");		//login_id의 세션 값 불러오기
		
		String ord_payment = request.getParameter("ord_payment");
		// 특정 회원의 장바구니 리스트 가져오기
		List<CartDTO> list = cartService.getCartListOrder(user_id);	
		// 특정 회원의 정보 가져오기
		ProfileDTO user_dto = profileService.getMember(user_id);
		
		// 반복문으로 입력
		int result = 0;
		OrderDTO dto;
		
		for(int i=0; i<list.size(); i++) {
			dto = new OrderDTO();
			dto.setOrd_code(list.get(i).getItem_code());
			dto.setOrd_name(list.get(i).getItem_name());
			dto.setOrd_color(list.get(i).getItem_color());
			dto.setOrd_size(list.get(i).getItem_size());
			dto.setOrd_image(list.get(i).getItem_image());
			dto.setOrd_price(list.get(i).getItem_price());
			dto.setOrd_qty(list.get(i).getCart_qty());
			dto.setOrd_totalprice(list.get(i).getCart_totalprice());
			dto.setUser_id(user_id);
			dto.setUser_name(user_dto.getUser_name());
			dto.setOrd_addr1(user_dto.getUser_addr1());
			dto.setOrd_addr2(user_dto.getUser_addr2());
			dto.setOrd_payment(ord_payment);
			
			result = orderService.orderInsert(dto);
			
			// 장바구니에서 삭제
			cartService.deleteCart(list.get(i).getCart_seq());
		}
		
		/* 화면 네비게이션 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("req", "../item/order_check.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
}
