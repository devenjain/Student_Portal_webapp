package com.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AdminDao;
import com.admin.services.AdminService;

/**
 * Servlet implementation class DeleteFacultyController
 */
public class DeleteFacultyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("fid");
		
		int fid = 0;
		
		if(!id.equals(null) || !id.equals("")) {
			fid = Integer.parseInt(id);
		}
		
		AdminService service = new AdminDao();
		
		if(service.deleteFaculty(fid))
			response.sendRedirect("FacultyListController");
		else {
			response.sendError(404);
		}
			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
