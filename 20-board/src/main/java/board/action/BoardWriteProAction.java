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
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 1. 데이터 처리
		String realFolder = request.getServletContext().getRealPath("boardUpload");
		MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		BoardBean bean = new BoardBean();
		bean.setBoard_name(multi.getParameter("board_name"));
		bean.setBoard_pass(multi.getParameter("board_pass"));
		bean.setBoard_subject(multi.getParameter("board_subject"));
		bean.setBoard_content(multi.getParameter("board_content"));
		bean.setBoard_file(multi.getOriginalFileName("board_file"));
		
		BoardDAO dao = new BoardDAO();
		int result = dao.insert(bean);
		
		// 2. 데이터 공유
		request.setAttribute("result", result);
		
		// 3. 파일 이름 리턴
		String command = null;
		if(result > 0) {
			command = "boardList.do";
		} else {
			response.setContentType("textx/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		return command;
	}

}
