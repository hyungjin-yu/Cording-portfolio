package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리 코드
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
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		// 공유 데이터 저장
		modelAndView.addObject("pg",pg);
		modelAndView.addObject("list",list);
		modelAndView.addObject("totalP",totalP);
		modelAndView.addObject("startPage",startPage);
		modelAndView.addObject("endPage",endPage);
		// view 처리 파일명 저장
		modelAndView.setViewName("boardList.jsp");
		return modelAndView;
	}

}
