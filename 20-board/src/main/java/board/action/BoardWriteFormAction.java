package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardWriteFormAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		// 2. 데이터 공유
		// 3. view 처리 파일명 리턴
		return "/board/boardWriteForm.jsp";
	}

	
}
