package com.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.admin.bean.FileBean;
import com.admin.dao.AdminDao;
import com.admin.services.AdminService;

/**
 * Servlet implementation class AddFileController
 */
public class AddFileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		List<FileItem> items = null;
		
		String field_name = null;
		String file_desc = null;
		String file_name = null;
		
		FileBean fileBean = new FileBean();
		
		try {
			
			items = upload.parseRequest(request);
			
			for(int i=0 ; i<items.size() ; i++) {
				
				FileItem item = items.get(i);
				
				if(item.isFormField()) {
					
					field_name = item.getFieldName();
									
					if(field_name.equalsIgnoreCase("FileDescription")) {
						
						file_desc = item.getString();
						System.out.println("fileDesc : " + file_desc);
						fileBean.setFile_desc(file_desc);
						
					}
					
				}
				
				else {
					
					field_name = item.getFieldName();
					System.out.println("Field-Name : " + field_name);					
					
					file_name = item.getName();
					
					System.out.println("filename : " + file_name);
					
					file_name = file_name.substring(file_name.lastIndexOf("\\")+1, file_name.length());
					
					System.out.println("FileName 2 : " + file_name);
									
					ServletContext context = getServletContext();
					
					String path = "D:\\Adv_java_programs\\Student_Portal_Webapp\\src\\main\\webapp\\Common_File";
										
					String abspath = getServletContext().getRealPath(path);
					System.out.println("ab dspath : " + abspath);
					
					File file = new File(path + File.separator + file_name);
					
					if(file_name.isEmpty()) {
						
						request.setAttribute("error", "*File can't be Empty!!");
						request.getRequestDispatcher("admin/FileView.jsp").forward(request, response);
						
					}
					
					else {
						
						System.out.println("MIME type : " + context.getMimeType(file_name));
						
						fileBean.setFile_type(context.getMimeType(file_name));
						
						if(context.getMimeType(file_name).equals("image/jpeg")
								|| context.getMimeType(file_name).equals("image/png")
								|| context.getMimeType(file_name).equals("image/jpg")
								|| context.getMimeType(file_name).equals("application/pdf")) {
								
							try {
								item.write(file);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							fileBean.setFile_name(file_name);
							
							AdminService service = new AdminDao();
							
							if(service.addFileBean(fileBean)) {
								response.sendRedirect("FileListController");
							}else {
								request.setAttribute("error", "Something went wrong");
								request.getRequestDispatcher("addProduct.jsp").forward(request, response);
							}
							
						}
						else {
							request.setAttribute("error", "only jpeg or png file allowed..");
							request.getRequestDispatcher("addProduct.jsp").forward(request, response);
						}
						
					}
									
				}
				
			}
		}
			
		 catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
