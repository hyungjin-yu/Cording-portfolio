package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardModifyFailAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/* 1.데이터 처리 */
		int board_num = (int)request.getAttribute("board_num");
		int pg = (int)request.getAttribute("pg");
		int result = (int)request.getAttribute("result");
		int err_no = Integer.parseInt(request.getParameter("err_no"));
		
		/* 2.데이터 공유 */
		request.setAttribute("board_num", board_num);
		request.setAttribute("pg", pg);
		request.setAttribute("result", result);
		request.setAttribute("err_no", err_no);
		
		return "/board/boardModifyFail.jsp";
	}

}
