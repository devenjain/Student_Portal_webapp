<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.admin.bean.SubjectBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject</title>

<style>

.manageMainBody{
margin-left: 45px;
margin-top:50px;
margin-right : 10px;
}

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

</style>

<SCRIPT>
function ShowAndHide() {
    var x = document.getElementById('SectionName');
    if (x.style.display == 'none') {
        x.style.display = 'block';
    } else {
        x.style.display = 'none';
    }
}
</SCRIPT>

</head>

<header style="margin-top:70px;">
<h1><center>Subject</center></h1>
</header>

<body>

<hr>

<%@include file="adminHeader.jsp" %>

<body>
    
   <div class = "manageMainBody">
    <h3>Add Subject</h3>
    
    <BUTTON ONCLICK="ShowAndHide()" class="btn btn-secondary">Click Here To ADD</BUTTON>
    
    	<div  ID="SectionName" STYLE="display:none">
	
	<br>
	<form action="./AddSubjectController" method="post">
		<table>
			<tr>
			<td>Subject ID</td>
			<td style="width:70px"><input type="number" name="sub_id" placeholder="ID" style="width:330px" required></td>
			&nbsp;&nbsp;&nbsp;
			<td>&nbsp;&nbsp;Subject Name</td>
			<td style="width:100px"><input type="text" name="sub_name" placeholder="Name" style="width:330px" required></td>
			&nbsp;&nbsp;&nbsp;
			<td style="width:50px"; padding:2px"><input type="submit" value="ADD"></td>
			</tr>
		</table>
	</form>
	
	</div>
	
	<hr>
	<br>
	<div class="stable">
	<!--  <table border = "3px" align="center" bgcolor="#7FFFD4">-->
	<table border = "5px" align="center" bgcolor="#8FBC8F" class="table table-striped">
	
		<tr>
			<b>
			<th><center>Subject ID</center></th>
			<th><center>Subject Name</center></th>
			<th><center>DELETE</center></th>
			<th><center>UPDATE</center></th>
			</b>			
		</tr>
		
		<tr>
			<%
				List<SubjectBean> subjectList = (List<SubjectBean>)request.getAttribute("studentList");
				if(subjectList != null){
					
					for(int i=0 ; i<subjectList.size() ; i++){
						
						SubjectBean subjectBean = subjectList.get(i);
						System.out.println(subjectBean.getSub_id());
						System.out.println(subjectBean.getSub_name());
						
																		
			%>
			
			<td><center><%=subjectBean.getSub_id()%></center></td>
			<td><center><%=subjectBean.getSub_name()%></center></td>
						
			<td><center><a class="delete" href = "./DeleteSubjectController?sub_id=<%=subjectBean.getSub_id()%>" style="text-decoration:none">   DELETE  </a></scenter></td>
		  	<td><center><a class="update" href = "Login.jsp?semail=<%=subjectBean.getSub_id()%>" style="text-decoration:none">   UPDATE   </a></center></td>
		</tr>
			
			<%
					}
				}else{
					out.println("no data");
				}
											
			%>
	
	</table>
	
	
	
	</div>

</div>
</body>
</html>