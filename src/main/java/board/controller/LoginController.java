package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import member.dao.MemberDAO;

@Controller
public class LoginController{

	@RequestMapping(value="/member/login.do")
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
