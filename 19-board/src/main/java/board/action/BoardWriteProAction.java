package board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.bean.BoardBean;
import board.dao.BoardDAO;

public class BoardWriteProAction implements Action{

	@Override
	public String exeute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		String realFolder = request.getServletContext().getRealPath("boardUpload");
		MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		BoardBean boardbean = new BoardBean();
		boardbean.setBoard_name(multi.getParameter("board_name"));
		boardbean.setBoard_pass(multi.getParameter("board_pass"));
		boardbean.setBoard_subject(multi.getParameter("board_subject"));
		boardbean.setBoard_content(multi.getParameter("board_content"));
		boardbean.setBoard_file(multi.getOriginalFileName("board_file"));
		
		System.out.println("이름 : " + boardbean.getBoard_name());
		System.out.println("비밀번호 : " + boardbean.getBoard_pass() );
		System.out.println("제목 : " + boardbean.getBoard_subject() );
		System.out.println("내용 : " + boardbean.getBoard_content() );
		System.out.println("파일명 : " +  boardbean.getBoard_file());
		
		// DB
		BoardDAO dao = new BoardDAO();
		int result = dao.insertArticle(boardbean);
		// 2. 데이터 공유
		request.setAttribute("result", result);
		
		// 3. view 처리 파일 이름 리턴
		// => 파일 이름 리턴
		String forward = null;
		
		if(result == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = "boardList.do";  // 목록의 첫 페이지를 요청
		}
		return forward;
	}

}
