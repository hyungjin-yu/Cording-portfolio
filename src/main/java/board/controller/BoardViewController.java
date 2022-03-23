package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));	
		HttpSession session = request.getSession();
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.boardView(seq);
		// 조회수 증가
		dao.updateHit(seq);
		
		String id = (String) session.getAttribute("id");
		String subject = (String) session.getAttribute("subject");
		String name = (String) session.getAttribute("name");
		String content = (String) session.getAttribute("content");
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);
		
		modelAndView.setViewName("boardView.jsp");
		return modelAndView;
	}

}
