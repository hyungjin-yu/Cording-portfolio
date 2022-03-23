package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import member.dao.MemberDAO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		// 1. 데이터 처리
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//DB
		MemberDAO dao = new MemberDAO();
		String name = dao.login(id, pwd);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		if(name != null) {
			HttpSession session = request.getSession();
			session.setAttribute("memName", name);
			session.setAttribute("memId", id);
			
			//response.sendRedirect("../board/boardList.do");
			modelAndView.setViewName("redirect:../board/boardList.do");
		} else {
			//response.sendRedirect("LoginForm.jsp");
			modelAndView.setViewName("redirect:LoginForm.jsp");
		}
		
		return modelAndView;
	}
}
