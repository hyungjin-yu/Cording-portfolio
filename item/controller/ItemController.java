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

		int endNum = pg * 5;
		int startNum = endNum - 4;

		List<ItemDTO> list = itemService.itemList(startNum, endNum);

		int totalA = itemService.getTotalA();
		int totalP = (totalA + 4) / 5;

		int startPage = (pg - 1) / 3 * 3 + 1;
		int endPage = startPage + 2;

		if (endPage > totalP)
			endPage = totalP;

		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// 공유 데이터 저장
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("list", list);
		modelAndView.addObject("totalP", totalP);
		modelAndView.addObject("startPage", startPage);
		modelAndView.addObject("endPage", endPage);
		// view 처리 파일명 저장
		modelAndView.addObject("req", "itemList.jsp");
		modelAndView.setViewName("../main/Index.jsp");
		return modelAndView;
	}

	// 상품 상세보기
	@RequestMapping(value = "/item/itemView.do")
	public ModelAndView itemView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));

		ItemDTO dto = itemService.itemView(seq);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("req", "itemView.jsp");

		modelAndView.setViewName("itemView.jsp");
		return modelAndView;
	}

}
