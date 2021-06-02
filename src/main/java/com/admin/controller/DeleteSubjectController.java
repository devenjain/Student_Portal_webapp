package com.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.dao.AdminDao;
import com.admin.services.AdminService;


public class DeleteSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			
			String id = request.getParameter("sub_id");
			
			int sub_id = 0;
			
			if(!id.equals(null) || !id.equals("")) {
				sub_id = Integer.parseInt(id);
			}
			
			AdminService service = new AdminDao();
			
			if(service.deleteSubject(sub_id))
				response.sendRedirect("StudentListController");
			else {
				response.sendError(404);
			}
				
		}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
