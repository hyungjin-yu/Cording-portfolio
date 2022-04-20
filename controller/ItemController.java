package item.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import item.bean.ItemDTO;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	// 상품 목록
	@RequestMapping("/item/itemList.do")
	public ModelAndView ItemList(HttpServletRequest request) {

		int pg = 1;
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));

		List<ItemDTO> list = itemService.itemList();

		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// 공유 데이터 저장
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		// view 처리 파일명 저장
		modelAndView.addObject("req", "../item/shoes_item.jsp");
		modelAndView.setViewName("itemList.jsp");
		return modelAndView;
	}

	// 신발 분류 목록
	@RequestMapping("/item/shoes_item.do")
	public ModelAndView ShoesList(HttpServletRequest request) {
		
		int pg = 1;
		
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		List<ItemDTO> list = itemService.itemList();
		ItemDTO dto = new ItemDTO();
		dto.setItem_name("item_name");
		dto.setItem_image1("item_image1");
		dto.setItem_details("item_details");
		list.add(dto);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// view 처리 파일명 저장
		modelAndView.addObject("req", "../item/shoes_item.jsp");
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("itemList.jsp");
		return modelAndView;
	}

	// 의류 분류 목록
	@RequestMapping(value = "/item/clothes_item.do")
	public ModelAndView ClothesList(HttpServletRequest request) {

		int pg = 1;
		
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		List<ItemDTO> list = itemService.itemList();
		ItemDTO dto = new ItemDTO();
		dto.setItem_name("item_name");
		dto.setItem_image1("item_image1");
		dto.setItem_details("item_details");
		list.add(dto);
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// view 처리 파일명 저장
		modelAndView.addObject("req", "../item/clothes_item.jsp");
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("itemList.jsp");
		return modelAndView;
	}

	// 용품 분류 목록
	@RequestMapping(value = "/item/sports_item.do")
	public ModelAndView SportsList(HttpServletRequest request) {

		int pg = 1;
		
		if (request.getParameter("pg") != null)
			pg = Integer.parseInt(request.getParameter("pg"));
		
		List<ItemDTO> list = itemService.itemList();
		ItemDTO dto = new ItemDTO();
		dto.setItem_name("item_name");
		dto.setItem_image1("item_image1");
		dto.setItem_details("item_details");
		list.add(dto);
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// view 처리 파일명 저장
		modelAndView.addObject("req", "../item/sports_item.jsp");
		modelAndView.addObject("list", list);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("itemList.jsp");
		return modelAndView;
	}

	// 상품 상세보기
	@RequestMapping(value = "/item/itemView.do")
	public ModelAndView itemView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		ItemDTO dto = itemService.itemView();

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("req", "../item/itemView.jsp");

		modelAndView.setViewName("itemlist.jsp");
		return modelAndView;
	}

}
