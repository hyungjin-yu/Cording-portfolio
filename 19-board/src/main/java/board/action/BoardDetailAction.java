package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardDetailAction implements Action {

	@Override
	public String exeute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String board_subject = request.getParameter("board_subject");
		String board_content = request.getParameter("board_content");
		String board_name = request.getParameter("board_name");
		String board_pass = request.getParameter("board_pass");
		
		BoardDAO dao = new BoardDAO();
		
		dao.updateReadcount(board_num);			 // 조회수 증가
		BoardBean bean = dao.boardView(board_num);
		
		request.setAttribute("bean", bean);
		request.setAttribute("pg", pg);
		request.setAttribute("board_subject", board_subject);
		request.setAttribute("board_content", board_content);
		request.setAttribute("board_name", board_name);
		request.setAttribute("board_pass", board_pass);
		
		return "/board/board_view.jsp";
	}
}
