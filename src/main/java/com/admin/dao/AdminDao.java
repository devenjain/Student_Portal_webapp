package com.admin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import java.sql.ResultSet;
import com.admin.bean.AdminBean;
import com.admin.bean.FileBean;
import com.admin.bean.SubjectBean;
import com.admin.services.AdminService;
import com.faculty.bean.FacultyBean;
import com.student.bean.StudentBean;
import com.util.ConnWithPostgresDB;


public class AdminDao implements AdminService{
	
	Connection conn = ConnWithPostgresDB.getConnPG();
	PreparedStatement pstmt;


	@Override
	public AdminBean checkLogin(String email, String password) {
		
		AdminBean bean = new AdminBean();
		
		if(conn!=null) {
				
			String loginSQL = "select * from admin where aemail = ? and apassword = ?";
			
			try {
				
				pstmt = conn.prepareStatement(loginSQL);
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				
//				java.sql.ResultSet rs = (ResultSet) pstmt.executeQuery();
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					bean.setAid(rs.getInt("aid"));
					bean.setAfname(rs.getString("afname"));
					bean.setAlname(rs.getString("alname"));
					bean.setAdob(rs.getDate("adob"));
					bean.setAgender(rs.getString("agender"));
					bean.setAphone(rs.getLong("aphone"));
					bean.setAemail(rs.getString("aemail"));
					bean.setApassword(rs.getString("apassword"));
											
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				
		return bean;
	}


	@Override
	public boolean addStudent(StudentBean studentBean) {
		
		boolean flag = false;
		
		if (conn != null) {
			
			System.out.println("Conn to thai gayu");
			
			String insertSQL = "insert into student(sid,sfname,smname,slname,semail,spassword,sphone,sdob,sgender) values (?,?,?,?,?,?,?,?,?)";
			
			try {
				System.out.println("Query pachi");
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setInt(1, studentBean.getSid());
				pstmt.setString(2, studentBean.getSfname());
				pstmt.setString(3, studentBean.getSmname());
				pstmt.setString(4, studentBean.getSlname());
				pstmt.setString(9, studentBean.getSgender());
				pstmt.setLong(7,studentBean.getSphone());
				pstmt.setDate(8, studentBean.getSdob());
				pstmt.setString(5, studentBean.getSemail());
				pstmt.setString(6, studentBean.getSpassword());
				
				int res = pstmt.executeUpdate();
				if(res>0){
					System.out.println("inserted succes");
					flag= true;
				}
				
				System.out.println("Query b run thai gai");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		return flag;
	}

	@Override
	public List<StudentBean> getAllStudent() {
		
		List<StudentBean> studentList = new ArrayList<StudentBean>();
		
		if (conn != null) {
			
			String selectSQL = "select * from student";
			
			try {
				
				pstmt = conn.prepareStatement(selectSQL);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					StudentBean studentBean = new StudentBean();
					
					studentBean.setSid(rs.getInt("sid"));
					studentBean.setSfname(rs.getString("sfname"));
					studentBean.setSmname(rs.getString("smname"));
					studentBean.setSlname(rs.getString("slname"));
					studentBean.setSdob(rs.getDate("sdob"));
					studentBean.setSemail(rs.getString("semail"));
					studentBean.setSpassword(rs.getString("spassword"));
					studentBean.setSphone(rs.getLong("sphone"));
					studentBean.setSgender(rs.getString("sgender"));
					
					studentList.add(studentBean);
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return studentList;
	}


	@Override
	public boolean addSubject(SubjectBean subjectBean) {
		
		boolean flag = false;
		
		if (conn != null) {
			
			System.out.println("Conn to thai gayu");
			
			String insertSQL = "insert into Subject(sub_id,sub_name) values(?,?)";
			
			try {
				
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setInt(1, subjectBean.getSub_id());
				pstmt.setString(2, subjectBean.getSub_name());
				
				int res = pstmt.executeUpdate();
				if(res>0){
					System.out.println("inserted succes");
					flag= true;
				}
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		return flag;
	}


	@Override
	public List<SubjectBean> getAllSubject() {

		List<SubjectBean> subjectList = new ArrayList<SubjectBean>();
		
		if(conn!= null) {
			
			String selectSQL = "select * from subject";
			
			try {
				
				pstmt = conn.prepareStatement(selectSQL);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
				
					SubjectBean bean = new SubjectBean();
					
					bean.setSub_id(rs.getInt("sub_id"));
					bean.setSub_name(rs.getString("sub_name"));
					
					
					subjectList.add(bean);
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return subjectList;
	}


	@Override
	public boolean addFaculty(FacultyBean facultyBean) {
		
		boolean flag = false;
		
		if(conn!=null) {
			
//			String insertSQL = "insert into faculty(fid,ffname,flname,femail,fpassword,sub_id,fphone,fdob,fgender) values (?,?,?,?,?,?,?,?,?)";
			String insertSQL = "insert into faculty(sub_id,fid,ffname,flname,femail,fpassword,fphone,fdob,fgender) values(?,?,?,?,?,?,?,?,?)";
//			String insertSQL = "insert into faculty(sub_id,fid,ffname,flname,femail,fpassword,fphone,fdob,fgender) values(321654,1002,'Deven','Jain','Deven@gmail.com','Deven#1002',9852364170,'2001-11-25','Male')";
			
			try {
				System.out.println("Query pachi");
				pstmt = conn.prepareStatement(insertSQL);
				
				
				pstmt.setInt(2, facultyBean.getFid());
				pstmt.setString(3, facultyBean.getFfname());
				pstmt.setString(4, facultyBean.getFlname());
				pstmt.setString(5, facultyBean.getFemail());
				pstmt.setString(6, facultyBean.getFpassword());
				pstmt.setInt(1, facultyBean.getSub_id());
				pstmt.setLong(7, facultyBean.getFphone());
				pstmt.setDate(8, facultyBean.getFdob());
				pstmt.setString(9, facultyBean.getFgender());
				
				
				int res = pstmt.executeUpdate();
				if(res>0){
					System.out.println("inserted succes");
					flag= true;
				}
				
				System.out.println("Query b run thai gai");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
					
		return flag;
	}


	@Override
	public List<FacultyBean> getAllFaculty() {
		
		List<FacultyBean> facultyList = new ArrayList<FacultyBean>();
		
		if(conn!=null) {
			
			String selectSQL = "select * from faculty natural join subject";
			
			try {
				
				pstmt = conn.prepareStatement(selectSQL);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					FacultyBean facultyBean = new FacultyBean();
					
					facultyBean.setFid(rs.getInt("fid"));
					facultyBean.setFfname(rs.getString("ffname"));
					facultyBean.setFlname(rs.getString("flname"));
					facultyBean.setFemail(rs.getString("femail"));
					facultyBean.setFpassword(rs.getString("fpassword"));
					facultyBean.setFdob(rs.getDate("fdob"));
					facultyBean.setFphone(rs.getLong("fphone"));
					facultyBean.setSub_id(rs.getInt("sub_id"));
					facultyBean.setFgender(rs.getString("fgender"));
					facultyBean.setSub_name(rs.getString("sub_name"));
									
					facultyList.add(facultyBean);
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}
		
		return facultyList;
	}


	@Override
	public boolean deleteStudent(int sid) {
		
		boolean flag = false;
		
		if(conn != null) {
			
			String deleteSQL = "delete from Student where sid=?";
			
			try {
				pstmt = (PreparedStatement) conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, sid);
				int res = pstmt.executeUpdate();
				
				if(res>0)
					flag = true;
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		return flag;
	}


	@Override
	public boolean deleteFaculty(int fid) {
		
		boolean flag = false;
		
		if(conn != null) {
			
			String deleteSQL = "delete from Faculty where fid=?";
			
			try {
				pstmt = (PreparedStatement) conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, fid);
				int res = pstmt.executeUpdate();
				
				if(res>0)
					flag = true;
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		return flag;
	}


	@Override
	public boolean deleteSubject(int sub_id) {
		
		boolean flag = false;
		
		if(conn!=null) {
			
			String deleteSQL = "delete from subject where sub_id = ?";
			
			try {
				
				pstmt = conn.prepareStatement(deleteSQL);
				pstmt.setInt(1, sub_id);
				
				int res = pstmt.executeUpdate();
				
				if(res>0) {
					flag = true;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return flag;
	}


	@Override
	public StudentBean getStudentBean(int sid) {
		
		StudentBean studentBean = null;
		
		if(conn != null) {
			
			String getStudentSQL = "select * from Student where sid = ?"; 
			
			try {
				
				pstmt = (PreparedStatement) conn.prepareStatement(getStudentSQL);
				pstmt.setInt(1, sid);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					studentBean = new StudentBean();
					
					studentBean.setSid(rs.getInt("sid"));
					studentBean.setSfname(rs.getString("sfname"));
					studentBean.setSmname(rs.getString("smname"));
					studentBean.setSlname(rs.getString("slname"));
					studentBean.setSdob(rs.getDate("sdob"));
					studentBean.setSemail(rs.getString("semail"));
					studentBean.setSpassword(rs.getString("spassword"));
					studentBean.setSphone(rs.getLong("sphone"));
					studentBean.setSgender(rs.getString("sgender"));
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return studentBean;
	}


	@Override
	public FacultyBean getFacultyBean(int fid) {

		FacultyBean facultyBean = null;
		
		if(conn != null) {
			
			String selectSQL = "select * from faculty natural join subject where fid=?";
			
			try {
				
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setInt(1, fid);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					facultyBean = new FacultyBean();
					
					facultyBean.setFid(rs.getInt("fid"));
					facultyBean.setFfname(rs.getString("ffname"));
					facultyBean.setFlname(rs.getString("flname"));
					facultyBean.setFemail(rs.getString("femail"));
					facultyBean.setFpassword(rs.getString("fpassword"));
					facultyBean.setFdob(rs.getDate("fdob"));
					facultyBean.setFphone(rs.getLong("fphone"));
					facultyBean.setSub_id(rs.getInt("sub_id"));
					facultyBean.setFgender(rs.getString("fgender"));
					facultyBean.setSub_name(rs.getString("sub_name"));
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return facultyBean;
	}


	@Override
	public SubjectBean getSubjectBean(int sub_id) {

		SubjectBean subjectBean = null;
		
		if(conn!=null) {
			
			String selectSQL = "select * from subject where sub_id = ?";
			
			try {
			
				pstmt = conn.prepareStatement(selectSQL);
				pstmt.setInt(1, sub_id);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					subjectBean = new SubjectBean();
					
					subjectBean.setSub_id(rs.getInt("sub_id"));
					subjectBean.setSub_name(rs.getString("sub_name"));
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		
		return subjectBean;
	}


	@Override
	public boolean updateStudent(StudentBean studentBean) {

		boolean flag = false;
		
		if(conn!=null) {
			
			String updatSQL = "update student set sfname=?, smname=?, slname=?, semail=?, spassword=?, sgender=?, sphone=?, sdob=? where sid=?";
			
			try {
				
				pstmt = conn.prepareStatement(updatSQL);
				
				pstmt.setString(1, studentBean.getSfname());
				pstmt.setString(2, studentBean.getSmname());
				pstmt.setString(3, studentBean.getSlname());
				pstmt.setString(4, studentBean.getSemail());
				pstmt.setString(5, studentBean.getSpassword());
				pstmt.setString(6, studentBean.getSgender());
				pstmt.setLong(7, studentBean.getSphone());
				pstmt.setDate(8, studentBean.getSdob());
				pstmt.setInt(9, studentBean.getSid());
				
				System.out.println(studentBean.getSid() + "------------------------------");
				
				
				int result = pstmt.executeUpdate();
				System.out.println("update ni query compile thai gai che");
				
				if(result > 0) {
					System.out.println("If ma aai gayu..true thai gayu.....res > 0");
					flag = true;
				}
				else {
					System.out.println("If ma gayu j  ni...true thayu j ni");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return flag;
	}


	@Override
	public boolean updateFaculty(FacultyBean facultyBean) {
		
		boolean flag = false;
		
		if(conn!=null) {
			
			String updatSQL = "update faculty set ffname=? , sub_id=?, flname=?, femail=?, fpassword=?, fgender=?, fphone=?, fdob=? where fid=?";
			
			try {
				
				pstmt = conn.prepareStatement(updatSQL);
				
				pstmt.setString(1, facultyBean.getFfname());
				pstmt.setInt(2, facultyBean.getSub_id());
				pstmt.setString(3, facultyBean.getFlname());
				pstmt.setString(4, facultyBean.getFemail());
				pstmt.setString(5, facultyBean.getFpassword());
				pstmt.setString(6, facultyBean.getFgender());
				pstmt.setLong(7, facultyBean.getFphone());
				pstmt.setDate(8, facultyBean.getFdob());
				pstmt.setInt(9, facultyBean.getFid());
				
				System.out.println(facultyBean.getFid() + "------------------------------");
				
				
				int result = pstmt.executeUpdate();
				System.out.println("update ni query compile thai gai che");
				
				if(result > 0) {
					System.out.println("If ma aai gayu..true thai gayu.....res > 0");
					flag = true;
				}
				else {
					System.out.println("If ma gayu j  ni...true thayu j ni");
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		return flag;
	}


	@Override
	public boolean updateSubject(SubjectBean subjectBean) {

		boolean flag = false;
			
		
		
		return flag;
	}


	@Override
	public boolean addFileBean(FileBean fileBean) {
		
		boolean flag = false;
		
		if (conn != null) {
			
			System.out.println("Conn to thai gayu");
			
			String insertSQL = "insert into CommonFile(file_desc,file_type,file_name) values(?,?,?)";
			
			try {
				
				pstmt = conn.prepareStatement(insertSQL);
				
				pstmt.setString(1, fileBean.getFile_desc());
				pstmt.setString(3, fileBean.getFile_name());
				pstmt.setString(2, fileBean.getFile_type());				
				
				int res = pstmt.executeUpdate();
				if(res>0){
					System.out.println("inserted succes");
					flag= true;
				}
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		return flag;
	}


	@Override
	public List<FileBean> getAllFile() {

		List<FileBean> fileList = new ArrayList<FileBean>();
		
		if(conn!=null) {
			
			String selectSQL = "select * from CommonFile";
			
			try {
				
				pstmt = conn.prepareStatement(selectSQL);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					FileBean bean = new FileBean();
					
					bean.setFile_desc(rs.getString("file_desc"));
					bean.setFile_id(rs.getInt("file_id"));
					bean.setFile_type(rs.getString("file_type"));
					bean.setFile_name(rs.getString("file_name"));
					
					fileList.add(bean);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return fileList;
	}
	
	

	
}
