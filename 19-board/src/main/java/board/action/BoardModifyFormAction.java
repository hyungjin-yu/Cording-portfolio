package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardModifyFormAction implements Action {

	@Override
	public String exeute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// DB
		BoardDAO dao = new BoardDAO();
		
		// 한 줄 데이터 가져오기
		BoardBean bean = dao.boardView(board_num);
		
		// 데이터 공유
		request.setAttribute("bean",bean);
		request.setAttribute("pg", pg);

		// view 처리 파일 리턴
		return "/board/board_modify.jsp";
	}
	
}
