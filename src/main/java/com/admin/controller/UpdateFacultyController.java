package com.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AdminDao;
import com.admin.services.AdminService;
import com.faculty.bean.FacultyBean;
import com.util.DataValidation;

/**
 * Servlet implementation class UpdateFacultyController
 */
public class UpdateFacultyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int fid = Integer.parseInt(request.getParameter("id"));
		int sub_id = Integer.parseInt(request.getParameter("subject"));
		String ffname = request.getParameter("firstname");
	 	String flname = request.getParameter("lastname");
		String femail = request.getParameter("email");
		String fpassword = request.getParameter("pwd");
		String fpassword1 = request.getParameter("pwd-repeat");
		String phone = request.getParameter("phone");
		String fgender = request.getParameter("gender");
		String date = request.getParameter("dob");
		java.sql.Date fdob = java.sql.Date.valueOf(date);
		
		System.out.println("Subject id : " + sub_id );
		
		Long fphone = null;
		
		boolean flag1 = false;
//		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean flag5 = false;
		boolean flag6 = false;
		boolean flag7 = true;
		
		if (DataValidation.nameValidation(ffname) == true) {
			flag1 = true;
			System.out.println("flag1 = true");
			request.setAttribute("fname", ffname);
		}
		else {
			flag1 = false;
			request.setAttribute("fnameError", " *Invalid Name!");
			request.setAttribute("nameErrormsg", "*Name must be contain only character");
		}
		
		if (DataValidation.nameValidation(flname) == true) {
			flag3 = true;
			System.out.println("flag3 = true");
			request.setAttribute("lname", flname);
		}
		else {
			flag3 = false;
			request.setAttribute("lnameError", " *Invalid Name!");
			request.setAttribute("nameErrormsg", "*Name must be contain only character");
		}
		
		if(DataValidation.emailValidation(femail) == true) {
			flag4 = true;
			System.out.println("flag4 = true");
			request.setAttribute("uemail", femail);
		}
		else {
			flag4 = false;
			System.out.println("Email false");
			request.setAttribute("emailError", " *Invalid Email!");			
		}
		
		if(DataValidation.passwordValidation(fpassword) == true) {
			flag5 = true;
			System.out.println("flag5 = true");
			request.setAttribute("upwd", fpassword);
		}
		else {
			flag5 = false;
			System.out.println("Wrong pass");
			request.setAttribute("pwdError", " *Invalid Password!");
			request.setAttribute("pwdErrormsg", "*A minimum 8 characters password contains a combination of uppercase, lowercase letter and number are required.");
		}
		
		if(DataValidation.phoneValidation(phone)) {
			flag6 = true;
			fphone = Long.parseLong(phone);
			System.out.println("flag6 = true  phone - " + phone);
			request.setAttribute("phone", fphone);
		}
		else {
			flag6=false;
			request.setAttribute("phoneerror", "*Invalid Phone Number!");
		}
		
		if(!fpassword.equals(fpassword1)) {
			flag7 = false;
			System.out.println("flag7 : true");
			request.setAttribute("missmatch", "*Password Missmatch!");
		}
		
		if(flag1 == false || flag3 == false || flag4 == false || flag5 == false || flag6 == false || flag7 == false) {
			request.getRequestDispatcher("admin/EditFacultyPage.jsp").forward(request, response);
		}
		else {
			
			FacultyBean facultyBean = new FacultyBean();
			
			facultyBean.setFfname(ffname);
			facultyBean.setFlname(flname);
			facultyBean.setFemail(femail);
			facultyBean.setFpassword(fpassword);
			facultyBean.setFphone(fphone);
			facultyBean.setFid(fid);
			facultyBean.setFgender(fgender);
			facultyBean.setFdob(fdob);
			facultyBean.setSub_id(sub_id);
			
			AdminService service = new AdminDao();
			
			if(service.updateFaculty(facultyBean)) {
				response.sendRedirect("FacultyListController");
			}
			else {
				response.sendError(404);
			}
			
		}
	
		
		doGet(request, response);
	}

}
