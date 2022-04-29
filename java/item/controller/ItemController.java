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

	// 상품 목록 : 카테고리 1
	@RequestMapping("/item/itemList_category1.do")
	public ModelAndView ItemList_category1(HttpServletRequest request) {
		String item_category1 = request.getParameter("item_category1");
		//System.out.println("item_category1 = " + item_category1);
		
		List<ItemDTO> list = itemService.itemList_category1(item_category1);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("req", "../item/itemList.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}

	// 상품 목록 : 카테고리 2
	@RequestMapping("/item/itemList_category2.do")
	public ModelAndView ItemList_category2(HttpServletRequest request) {
		String item_category1 = request.getParameter("item_category1");
		String item_category2 = request.getParameter("item_category2");
		//System.out.println("item_category1 = " + item_category1);
		
		List<ItemDTO> list = itemService.itemList_category2(item_category1, item_category2);

		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("req", "../item/itemList.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}
	
	// 상품 목록 : 카테고리 3
		@RequestMapping("/item/itemList_category3.do")
		public ModelAndView ItemList_category3(HttpServletRequest request) {
			String item_category1 = request.getParameter("item_category1");
			String item_category2 = request.getParameter("item_category2");
			String item_category3 = request.getParameter("item_category3");
			
			List<ItemDTO> list = itemService.itemList_category3(item_category1, item_category2, item_category3);

			// 화면 네비게이션
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("list", list);
			modelAndView.addObject("req", "../item/itemList.jsp");
			modelAndView.setViewName("../main/index.jsp");
			
			return modelAndView;
		}

	// 상품 상세보기
	@RequestMapping(value = "/item/itemView.do")
	public ModelAndView itemView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String item_code = request.getParameter("item_code");
		
		ItemDTO dto = itemService.itemView(item_code);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("req", "../item/itemView.jsp");
		modelAndView.setViewName("../main/index.jsp");
		
		return modelAndView;
	}

}