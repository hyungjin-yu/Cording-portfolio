package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
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
		request.setAttribute("seq", seq);
		request.setAttribute("pg", pg);
		request.setAttribute("dto", dto);
		
		return "boardView";
	}
}
