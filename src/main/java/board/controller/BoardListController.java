package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardListController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. 데이터 처리
		int pg = 1;
		if(request.getParameter("pg") != null)
		pg = Integer.parseInt(request.getParameter("pg"));
		
		int endNum = pg * 5;
		int startNum = endNum - 4;
		
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.boardList(startNum, endNum);
		
		int totalA = dao.getTotalA();
		int totalP = (totalA + 4) / 5;
		
		int startPage = (pg-1) / 3*3 + 1;
		int endPage = startPage + 2;
		
		if(endPage > totalP) endPage = totalP;
		
		// 2. 화면 네비게이션
		request.setAttribute("pg", pg);
		request.setAttribute("list", list);
		request.setAttribute("totalP", totalP);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		return "boardList";		// boardList.jsp도 가능
	}

}
