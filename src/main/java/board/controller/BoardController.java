package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Controller
public class BoardController {
	@RequestMapping(value="/board/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// db
		BoardDAO dao = new BoardDAO();
		int result = dao.boardDelete(seq);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		
		modelAndView.setViewName("boardDelete.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	
	@RequestMapping(value="/board/boardWriteForm.do")
	public ModelAndView boardWriteForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("boardWriteForm.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	
	@RequestMapping(value="/board/boardView.do")
	public ModelAndView boardView(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
