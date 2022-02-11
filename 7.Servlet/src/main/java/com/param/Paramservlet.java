package com.param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;

public class Paramservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Paramservlet() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 처리
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String result = name + "님의 나이는 " + age + "살이므로, ";
		if(age >= 20) {
			result += "성인 입니다.";
		} else {
			result += "청소년 입니다.";
		}
		// view 처리
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>서블릿</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(result);
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
