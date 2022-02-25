package exam3.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		String message = "명령어를 요청 파라미터로 전달";
		// 2. 데이터 공유
		request.setAttribute("message", message);
		// 3. view 처리 파일 리턴
		return "/exam3/messageView.jsp";
	}

}
