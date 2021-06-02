package com.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AdminDao;
import com.admin.services.AdminService;
import com.student.bean.StudentBean;

/**
 * Servlet implementation class StudentListController
 */
public class StudentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		AdminService service = new AdminDao();
		
		List<StudentBean> studentList = service.getAllStudent();
		
		System.out.println("inside listcontroller");
				
		request.setAttribute("studentList", studentList);
		request.getRequestDispatcher("admin/StudentList.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
