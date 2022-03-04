package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDAO;

public class BoardDeleteProAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String board_pass = request.getParameter("board_pass");
		
		// DB
		BoardDAO dao = new BoardDAO();
		
		// 1) 글쓴이가 맞는지 확인
		boolean isWriter = dao.isBoardWriter(board_num, board_pass);
		
		// 2) 글쓴이가 맞다면 삭제
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String view = null;
		if(isWriter) {
			int result = dao.boardDelete(board_num);
			
			if(result > 0) {
				out.println("<script>");
				out.println("alert('삭제 성공했습니다.')");
				out.println("location.href='boardList.do?pg=" + pg + "'");
				out.println("</script>");
			} else {
				out.println("<script>");
				out.println("alert('삭제 실패했습니다.')");
				out.println("location.href='boardDetail.do?board_num="+ board_num + "&pg=" + pg +"'");
				out.println("</script>");
			}
		} else {
			out.println("<script>");
			out.println("alert('삭제할 권한이 없습니다.')");
			out.println("location.href='boardDetail.do?board_num="+ board_num + "&pg=" + pg +"'");
			out.println("</script>");
		}
		
		// 파일 이름 리턴
		return view; 
	}

}
