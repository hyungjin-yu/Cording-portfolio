package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardReplyProAction implements Action{

	@Override
	public String exeute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		int pg = Integer.parseInt(request.getParameter("pg"));
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int board_re_ref = Integer.parseInt(request.getParameter("board_re_ref"));
		int board_re_lev = Integer.parseInt(request.getParameter("board_re_lev"));
		int board_re_seq = Integer.parseInt(request.getParameter("board_re_seq"));
		String board_name = request.getParameter("board_name");
		String board_pass = request.getParameter("board_pass");
		String board_subject = request.getParameter("board_subject");
		String board_content = request.getParameter("board_content");
		
		System.out.println(board_num);
		
		BoardBean boardBean = new BoardBean();
		boardBean.setBoard_num(board_num);
		boardBean.setBoard_re_ref(board_re_ref);
		boardBean.setBoard_re_lev(board_re_lev);
		boardBean.setBoard_re_seq(board_re_seq);
		boardBean.setBoard_name(board_name);
		boardBean.setBoard_pass(board_pass);
		boardBean.setBoard_subject(board_subject);
		boardBean.setBoard_content(board_content);
		
		// DB
		BoardDAO dao = new BoardDAO();
		int result = dao.insertReplyArticle(boardBean);
		
		// 2. 데이터 공유
		// 3. view 처리 파일 리턴
		String forward = null;
		if(result > 0) {
			// 새로고침하면 답글이 계속 추가
			// forward = "boardList.do?pg=" + pg;
			// 주소창의 주소가 바뀌어야함
			response.sendRedirect("boardList.do?pg=" + pg);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답글 저장 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
