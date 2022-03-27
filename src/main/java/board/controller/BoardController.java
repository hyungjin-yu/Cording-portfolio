package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/board/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		// db
		BoardDAO dao = new BoardDAO();
		int flag = dao.boardDelete(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("flag",flag);
		modelAndView.addObject("seq",seq);
		modelAndView.addObject("pg",pg);
		modelAndView.setViewName("boardDelete.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pg = Integer.parseInt(request.getParameter("pg"));
		// DB
		/* 목록보기 */
		int endNum = pg*5;
		int startNum = endNum - 4;
		
		// dao 작업
		BoardDAO dao = new BoardDAO();
	    List<BoardDTO> list = dao.boardList(startNum, endNum);
	    
	    int totalA = dao.getTotalA();   // 총글수 구하기
	    int totalP = (totalA + 4) / 5;
	    
		int startPage = (pg-1)/3*3 + 1;
	    int endPage = startPage + 2;
	    
	    // endPage 값 보정
	    if(endPage > totalP) endPage = totalP;
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pg",pg);
		modelAndView.addObject("endNum",endNum);
		modelAndView.addObject("startNum",startNum);
		modelAndView.addObject("totalP",totalP);
		modelAndView.addObject("list", list);
		modelAndView.setViewName("boardList.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardModify.do")
	public ModelAndView boardModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		// DB처리
		BoardDTO dto = new BoardDTO(); 	
		dto.setSeq(seq);
		dto.setSubject(subject);
		dto.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		int result = dao.boardModify(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("boardModify.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardView.do")
	public ModelAndView boardView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// boardModifyForm.jsp에 보여줄 데이터 필요
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.boardView(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.setViewName("boardView.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		// 세션에 저장된 데이터 받기
		String name = (String)session.getAttribute("memName");
		String id = (String)session.getAttribute("memId");

		// DB 처리
		BoardDTO dto = new BoardDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setSubject(subject);
		dto.setContent(content);
		   
		BoardDAO dao = new BoardDAO();
		int result = dao.boardWrite(dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("dto", dto);
		modelAndView.setViewName("boardWrite.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value="/board/boardWriteForm.do")
	public ModelAndView boardWriteForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("boardWriteForm.jsp");
		return modelAndView;
	}
}
