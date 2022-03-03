package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardDeleteProAction implements Action {
	
	public String exeute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		String board_pass = request.getParameter("board_pass");
		
		// DB
		BoardDAO dao = new BoardDAO();
		// 1) 글쓴이가 맞는지 확인
		boolean isWriter = dao.isArticleBoardWriter(board_num, board_pass);
		
		// 2) 글쓴이가 맞다면 삭제
		int result = 0;
		if(isWriter) {
			result = dao.boardDelete(board_num);
		}
		
		// 데이터 공유
		request.setAttribute("board_num", board_num);
		request.setAttribute("pg", pg);
		request.setAttribute("result", result);
		
		// 파일 이름 리
		return "/board/board_deletePro.jsp";
	}
}
