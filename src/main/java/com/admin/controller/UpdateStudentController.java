package com.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AdminDao;
import com.admin.services.AdminService;
import com.student.bean.StudentBean;
import com.util.DataValidation;

/**
 * Servlet implementation class UpdateStudentController
 */
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sid = Integer.parseInt(request.getParameter("id"));
		String sfname = request.getParameter("firstname");
		String smname = request.getParameter("middlename");
	 	String slname = request.getParameter("lastname");
		String semail = request.getParameter("email");
		String spassword = request.getParameter("pwd");
		String spassword1 = request.getParameter("pwd-repeat");
		String phone = request.getParameter("phone");
		String sgender = request.getParameter("gender");
		String date = request.getParameter("dob");
		java.sql.Date sdob = java.sql.Date.valueOf(date);
		
		Long sphone = null;
		
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;
		boolean flag6 = false;
		boolean flag7 = true;
		
		if (DataValidation.nameValidation(sfname) == true) {
			flag1 = true;
			System.out.println("flag1 = true");
			request.setAttribute("fname", sfname);
		}
		else {
			flag1 = false;
			request.setAttribute("fnameError", " *Invalid Name!");
			request.setAttribute("nameErrormsg", "*Name must be contain only character");
		}
		
		if (DataValidation.nameValidation(smname) == true) {
			flag2 = true;
			System.out.println("flag2 = true");
			request.setAttribute("mname", smname);
		}
		else {
			flag2 = false;
			request.setAttribute("mnameError", " *Invalid Name!");
			request.setAttribute("nameErrormsg", "*Name must be contain only character");
		}
		
		if (DataValidation.nameValidation(slname) == true) {
			flag3 = true;
			System.out.println("flag3 = true");
			request.setAttribute("lname", slname);
		}
		else {
			flag3 = false;
			request.setAttribute("lnameError", " *Invalid Name!");
			request.setAttribute("nameErrormsg", "*Name must be contain only character");
		}
		
		if(DataValidation.emailValidation(semail) == true) {
			flag4 = true;
			System.out.println("flag4 = true");
			request.setAttribute("uemail", semail);
		}
		else {
			flag4 = false;
			System.out.println("Email false");
			request.setAttribute("emailError", " *Invalid Email!");			
		}
		
		if(DataValidation.passwordValidation(spassword) == true) {
			flag5 = true;
			System.out.println("flag5 = true");
			request.setAttribute("upwd", spassword);
		}
		else {
			flag5 = false;
			System.out.println("Wrong pass");
			request.setAttribute("pwdError", " *Invalid Password!");
			request.setAttribute("pwdErrormsg", "*A minimum 8 characters password contains a combination of uppercase, lowercase letter and number are required.");
		}
		
		if(DataValidation.phoneValidation(phone)) {
			flag6 = true;
			sphone = Long.parseLong(phone);
			System.out.println("flag6 = true  phone - " + phone);
			request.setAttribute("phone", sphone);
		}
		else {
			flag6=false;
			request.setAttribute("phoneerror", "*Invalid Phone Number!");
		}
		
		if(!spassword.equals(spassword1)) {
			flag7 = false;
			System.out.println("flag7 : true");
			request.setAttribute("missmatch", "*Password Missmatch!");
		}
		
		if(flag1 == false || flag2 == false || flag3 == false || flag4 == false || flag5 == false || flag6 == false || flag7 == false) {
			request.getRequestDispatcher("admin/EditStudentPage.jsp").forward(request, response);
		}
		else {
			
			StudentBean studentBean = new StudentBean();
			
			studentBean.setSfname(sfname);
			studentBean.setSmname(smname);
			studentBean.setSlname(slname);
			studentBean.setSemail(semail);
			studentBean.setSpassword(spassword1);
			studentBean.setSphone(sphone);
			studentBean.setSid(sid);
			studentBean.setSgender(sgender);
			studentBean.setSdob(sdob);
			
			AdminService service = new AdminDao();
			
			if(service.updateStudent(studentBean)) {
				response.sendRedirect("StudentListController");
			}
			else {
				response.sendError(404);
			}
			
		}
	
		
		doGet(request, response);
	}

}
