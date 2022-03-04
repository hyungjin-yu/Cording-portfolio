package board.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardListAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		int pg = 0;
		if(request.getParameter("pg") != null) {
			pg = Integer.parseInt(request.getParameter("pg"));
		} else {
			pg = 1;
		}
		// 1) 목록 출력
		int endNum = pg*10;
		int startNum = endNum - 9;
		// DB
		BoardDAO dao = new BoardDAO();
		// 표시할 리스트 객체
		List<BoardBean> list = dao.boardList(startNum, endNum);
		
		// 2) 페이징 처리
		int totalA = dao.getTotalA();	// 총 글 수 
		int totalP = (totalA + 9) / 10;	// 총 페이지 수
		
		// 블럭 5개
		int startPage = (pg - 1)/5*5 + 1;
		int endPage = startPage + 4;	// 페이지 번호를 5개씩 한다면 +4
		
		// endPage 값 보정
		if(endPage > totalP) endPage = totalP;
		
		// 2. 데이터 공유
		request.setAttribute("list", list);
		request.setAttribute("pg", pg);
		request.setAttribute("totalP", totalP);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		// 3. view 처리 파일명 리턴
		return "/board/boardList.jsp";
	}

}
