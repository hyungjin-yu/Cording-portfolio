package exam2.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageGuestAction implements Action{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		/* 데이터 처리 + 데이터 공유 + view 처리 화면 선택 */
		// 1. 데이터 처리 
		String result = "홍길동 입니다.";
		// 2. 데이터 공유
		request.setAttribute("result", result);
		// 3. view 처리 파일 선택
		return "/messageView.jsp";
	}

}
