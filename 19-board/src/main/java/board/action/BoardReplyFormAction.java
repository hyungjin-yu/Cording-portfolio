package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardReplyFormAction implements Action{

	@Override
	public String exeute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 데이터 처리
		int pg = Integer.parseInt(request.getParameter("pg"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		// DB
		// => 원글 데이터 읽어오기
		BoardDAO dao = new BoardDAO();
		BoardBean boardBean = dao.boardView(board_num);
		
		// 데이터 공유
		request.setAttribute("pg", pg);
		request.setAttribute("boardBean", boardBean);
		
		// view 처리 파일 리턴
		return "/board/board_reply.jsp";
	}
}
