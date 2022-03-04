package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardModifyFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		//System.out.println(pg);
		
		//DB
		BoardDAO dao = new BoardDAO();
		
		// 한 줄 데이터 가져오기
		BoardBean bean = dao.boardView(board_num);
		
		// 데이터 공유
		request.setAttribute("bean", bean);
		request.setAttribute("pg", pg);
		
		// 파일 이름 리턴
		return "/board/boardModify.jsp";
	}

}
