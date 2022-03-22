package board.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 1. 데이터 처리
		try {
			request.setCharacterEncoding("utf-8");	// 한글 인코딩 설정
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//DB
		MemberDAO dao = new MemberDAO();
		String name = dao.login(id, pwd);
		
		if(name != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			
			try {
				response.sendRedirect("../board/boardList.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			try {
				response.sendRedirect("LoginForm.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
