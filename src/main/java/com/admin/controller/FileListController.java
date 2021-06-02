package com.admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.bean.FileBean;
import com.admin.bean.SubjectBean;
import com.admin.dao.AdminDao;
import com.admin.services.AdminService;

/**
 * Servlet implementation class FileListController
 */
public class FileListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AdminService service = new AdminDao();
		
		List<FileBean> fileList = service.getAllFile();
		
//		System.out.println("inside listcontroller");
				
		request.setAttribute("fileList", fileList);
		request.getRequestDispatcher("admin/FileView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
