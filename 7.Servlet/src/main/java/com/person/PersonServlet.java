package com.person;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PersonServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String hobby = request.getParameter("hobby");
		String red = request.getParameter("red");
		String blue = request.getParameter("blue");
		String yellow = request.getParameter("yellow");
		String Java = request.getParameter("Java");
		String JSP = request.getParameter("JSP");
		String Spring = request.getParameter("Spring");
		String jQuery = request.getParameter("jQuery");
		String Servlet = request.getParameter("Servlet");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
