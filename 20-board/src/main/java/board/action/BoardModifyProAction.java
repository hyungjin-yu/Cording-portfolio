package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardModifyProAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		String board_name = request.getParameter("board_name");
		String board_pass = request.getParameter("board_pass");
		String board_subject = request.getParameter("board_subject");
		String board_content = request.getParameter("board_content");
		
		// DB
		BoardDAO dao = new BoardDAO();
		
		// 글쓴이인지 확인
		boolean isWriter = dao.isBoardWriter(board_num, board_pass);
		String command = null;
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(isWriter) {
			BoardBean bean = new BoardBean();
			bean.setBoard_num(board_num);
			bean.setBoard_name(board_name);
			bean.setBoard_pass(board_pass);
			bean.setBoard_subject(board_subject);
			bean.setBoard_content(board_content);
			
			int result = dao.check(bean);
			
			// view 처리 파일 리턴
			if(result == 0) {
				command = "boardModifyFail.do?err_no=1";	// 비번 오류
			} else {
				out.println("<script>");
				out.println("alert('수정 성공')");
				out.println("location.href='boardDetail.do?pg=" + pg + "&board_num=" + board_num+"'");
				out.println("</script>");
			}
			} else { // 글쓴이가 아닐 경우
				command = "boardModifyFail.do?err_no=2";   // 권한이 없음
			}
		return command;
	}

}
