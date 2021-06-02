package com.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.admin.bean.AdminBean;
import com.admin.dao.AdminDao;
import com.admin.services.AdminService;

public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String loginemail = (String) session.getAttribute("loginEmail");
		String loginpwd = (String) session.getAttribute("loginpwd");
		
		System.out.println("email : "+loginemail);
		System.out.println("pwd : "+loginpwd);
		
		
		AdminService service = new AdminDao();
		
		AdminBean  adminBean = service.checkLogin(loginemail, loginpwd);
		
		if(loginemail.equals(adminBean.getAemail()) && loginpwd.equals(adminBean.getApassword())) {
			System.out.println("Login Successfull!");
			session.setAttribute("adminbean", adminBean);
			request.getRequestDispatcher("admin/adminHome.jsp").forward(request, response);
						
		}
		else {
			System.out.println("Login Failes!");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
