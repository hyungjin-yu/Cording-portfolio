package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDeleteFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		// 2. 데이터 공유
		request.setAttribute("board_num", board_num);
		request.setAttribute("pg", pg);
		
		// 3. 파일 이름 리턴
		return "/board/boardDelete.jsp";
	}

}
