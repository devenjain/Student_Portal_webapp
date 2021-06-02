package com.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.bean.SubjectBean;
import com.admin.dao.AdminDao;
import com.admin.services.AdminService;


public class AddSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		int sub_id = Integer.parseInt(request.getParameter("sub_id"));
		String sub_name = request.getParameter("sub_name");
		
		SubjectBean subjectBean = new SubjectBean();
		
		subjectBean.setSub_id(sub_id);
		subjectBean.setSub_name(sub_name);
		
		AdminService service = new AdminDao();
		
		if(service.addSubject(subjectBean)) {
			response.sendRedirect("SubjectListController");
		}
		else {
			response.sendError(404);
		}
		
		doGet(request, response);
		
	}

}
