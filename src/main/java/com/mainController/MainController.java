package com.mainController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String whoIs = request.getParameter("whoIs");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("loginEmail", email);
		session.setAttribute("loginpwd", password);
		
		System.out.println(whoIs);
		
		if(whoIs.equals("1")) {
			response.sendRedirect("AdminLoginController");
		}
		else if(whoIs.equals("2")) {
			response.sendRedirect("FacultyLoginController");
		}
		else{
			response.sendRedirect("StudentLoginController");
		}
		
		
		doGet(request, response);
	}

}
