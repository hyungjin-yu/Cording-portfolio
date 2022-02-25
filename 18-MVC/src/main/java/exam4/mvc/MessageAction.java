package exam4.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// 1. 데이터 처리
		String result = "명령어를 요청 URI로 전달";
		
		// 2. 데이터 공유
		request.setAttribute("result", result);
		
		// 3. view 처리파일 리턴
		return "/exam4/messageView.jsp";
	}

}
