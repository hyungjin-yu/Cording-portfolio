package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardWriteController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		// DB처리
		BoardDTO dto = new BoardDTO();  
		
		dto.setId(id);
		dto.setName(name);
		dto.setSubject(subject);
		dto.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		int result = dao.boardWrite(dto);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		
		modelAndView.setViewName("boardWrite.jsp");
		return modelAndView;
	}

}
