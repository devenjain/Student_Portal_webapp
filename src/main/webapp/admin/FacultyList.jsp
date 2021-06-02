<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.faculty.bean.FacultyBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Faculty Table</title>

<style type="text/css">

.manageMainBody{
margin-left: 45px;
margin-top:50px;
margin-right : 10px;
}

.delete {
background-color:"GREY";
color: black;
/*padding: 2px;*/
padding-left: 26px;
padding-right: 26px;
padding-top: 2px;
padding-bottom: 2px;
text-decoration: none;
border: 1px solid black;
height:10px;
width: 250px;
font-size:14px;
}
.delete:hover {
background-color: black;
color: white;
transition-delay: .1s;
transition-property: background-color;
cursor: pointer;
}
.update {
background-color:"GREY";
color: black;
/*padding: 2px;*/
padding-left: 26px;
padding-right: 26px;
padding-top: 2px;
padding-bottom: 2px;
text-decoration: none;
border: 1px solid black;
height:10px;
width: 250px;
font-size:14px;
}
.update:hover {
background-color: black;
color: white;
transition-delay: .1s;
transition-property: background-color;
cursor: pointer;
}
.add {
background-color:"GREY";
color: black;
/*padding: 2px;*/
padding-left: 26px;
padding-right: 26px;
padding-top: 2px;
padding-bottom: 2px;
text-decoration: none;
border: 1px solid black;
height:10px;
width: 250px;
font-size:14px;
}
.add:hover {
background-color: black;
color: white;
transition-delay: .1s;
transition-property: background-color;
cursor: pointer;
}
.short {
background-color:"GREY";
color: black;
/*padding: 2px;*/
margin-left:5px;
padding-left: 26px;
padding-right: 26px;
padding-top: 2px;
padding-bottom: 2px;
text-decoration: none;
border: 1px solid black;
height:10px;
width: 250px;
font-size:14px;
}
.short:hover {
background-color: black;
color: white;
transition-delay: .1s;
transition-property: background-color;
cursor: pointer;
}
.search{
	float:right;
	margin-right:5px;
}
footer{
    position: fixed;
  left: 0;
  bottom: 0;
  width: 100%;
  /* background-color: red; */
  color: white;
  text-align: center;
}
.stable{
font-size:14px;
}
</style>

</head>
<header style="margin-top:70px;">
<h1><center>Faculty Table</center></h1>
</header>

<body>

<hr>

<%@include file="adminHeader.jsp" %>

<div class = "manageMainBody">
	
	<a class="short" href = "StudentShortedListController" style="text-decoration:none" border="1px"><B>Short By Name</a>
	
	<div class = "search">
	<form action="StudentSearchController" method="post">
		<table>
			<tr>
			<td style="width:200px"><input type="text" name="txtStudentName" placeholder="Search By name" style="width:330px"></td>
			<td style="width:50px"; padding:2px"><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
	</div>
<br>
<!-- <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"> -->
	<br>
	<div class="stable">
	<!--  <table border = "3px" align="center" bgcolor="#7FFFD4">-->
	<table border = "5px" align="center" bgcolor="#8FBC8F" class="table table-striped">
	
		<tr>
			<b>
			<th><center>ID</center></th>
			<th><center>Name</center></th>
			<th><center>Email</center></th>
			<th><center>Password</center></th>
			<th><center>Assigned Subject</center></th>
			<th><center>BirthDate</center></th>
			<th><center>Gender</center></th>
		 	<th><center>Phone</center></th> 
			<th><center>DELETE</center></th>
			<th><center>UPDATE</center></th>
			</b>			
		</tr>
		
		<tr>
			<%
				List<FacultyBean> facultyList = (List<FacultyBean>)request.getAttribute("facultyList");
				if(facultyList != null){
					
					for(int i=0 ; i<facultyList.size() ; i++){
						
						FacultyBean facultyBean = facultyList.get(i);
																		
			%>
			
			<td><%=facultyBean.getFid() %>
			<td><%=facultyBean.getFfname() %>&nbsp;<%=facultyBean.getFlname() %>
			<td><%=facultyBean.getFemail()%></td>
			<td><%=facultyBean.getFpassword()%></td>
			<td><%=facultyBean.getSub_name() %></td>
			<td><%=facultyBean.getFdob() %></td>
			<td><%=facultyBean.getFgender()%></td>
			<td><%=facultyBean.getFphone() %></td>
						
			<td><center><a class="delete" href = "./DeleteFacultyController?fid=<%=facultyBean.getFid()%>" style="text-decoration:none">   DELETE  </a></center></td>
		  	<td><center><a class="update" href = "./EditFacultyController?fid=<%=facultyBean.getFid()%>" style="text-decoration:none">   UPDATE   </a></center></td>
		</tr>
			
			<%
					}
				}else{
					out.println("no data");
				}
											
			%>
	
	</table>
	</div>
	<br>
	<center><a class="add" href = "admin/AddFacultyPage.jsp" style="text-decoration:none" border="1px"><B>Add More</a></center>
	<br><br><br>
	
	<!-- Footer -->
<!-- <footer class="bg-light text-center text-lg-start">
  Grid container
  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);" style="align : center">
   <center> © 2021 Copyright: dvn.chopra2511@gmail.com</center>
    
  </div>
  Copyright
</footer> -->
<!-- Footer -->
 <%-- <%@include file="footer.jsp" %> --%>
 </div>
</body>
</html>