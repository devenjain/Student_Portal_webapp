package com.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AdminDao;
import com.admin.services.AdminService;
import com.faculty.bean.FacultyBean;
import com.student.bean.StudentBean;

/**
 * Servlet implementation class EditFacultyController
 */
public class EditFacultyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int fid = Integer.parseInt(request.getParameter("fid"));
		System.out.println("Requested FID : " + fid);
		AdminService service = new AdminDao();

		FacultyBean facultyBean = service.getFacultyBean(fid);
		
		request.setAttribute("facultyBean", facultyBean);
		request.getRequestDispatcher("admin/EditFacultyPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
