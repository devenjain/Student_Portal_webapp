package com.admin.services;

import java.util.List;

import com.admin.bean.AdminBean;
import com.admin.bean.FileBean;
import com.admin.bean.SubjectBean;
import com.faculty.bean.FacultyBean;
import com.student.bean.StudentBean;

public interface AdminService {

	public AdminBean checkLogin(String email,String password);
	
	public boolean addStudent(StudentBean studentBean);
	
	public List<StudentBean> getAllStudent();

	public boolean addSubject(SubjectBean subjectBean);

	public List<SubjectBean> getAllSubject();
	
	public boolean addFaculty(FacultyBean facultyBean);
	
	public List<FacultyBean> getAllFaculty();
	
	public boolean deleteStudent(int sid);
	
	public boolean deleteFaculty(int fid);
	
	public boolean deleteSubject(int sub_id);
	
	public StudentBean getStudentBean(int sid);
	
	public FacultyBean getFacultyBean(int fid);
	
	public SubjectBean getSubjectBean(int sub_id);
	
	public boolean updateStudent(StudentBean studentBean);
	
	public boolean updateFaculty(FacultyBean facultyBean);
	
	public boolean updateSubject(SubjectBean subjectBean);
	
	public boolean addFileBean(FileBean fileBean);
	
	public List<FileBean> getAllFile();
}
