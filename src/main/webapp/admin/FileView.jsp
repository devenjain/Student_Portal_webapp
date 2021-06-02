<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.admin.bean.FileBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>File</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

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
<h1><center>Upload File</center></h1>
</header>

<body>

<hr>

<%@include file="adminHeader.jsp" %>

<body>
    
   <div class = "manageMainBody">
    <h3>Add File</h3>
    <br>
    <BUTTON ONCLICK="ShowAndHide()" class="btn btn-secondary">Click Here To ADD</BUTTON>
    	<div  ID="SectionName" STYLE="display:none">
	
	<br>
	<form action="./AddFileController" method="post" enctype="multipart/form-data">
	 	
	 	<div class="form-group">
    			<label for="formGroupExampleInput">Description</label>
    			<input type="text" class="form-control" id="formGroupExampleInput" placeholder="Add Description of File" name="FileDescription">
  		</div>
 	 	<!-- <div class="form-group">
  			  <label for="formGroupExampleInput2">File</label>
    			<input type="file" class="form-control" id="customFile" />
  		</div> -->
  		<input type="file" id="customFile" name="image"> ${error }
  		<br>
  		<button type="submit" class="btn btn-primary">Upload</button>

	</form>
	
	</div>
	<hr>
	
	<br>
	<div class="stable">
	<!--  <table border = "3px" align="center" bgcolor="#7FFFD4">-->
	<table border = "5px" align="center" bgcolor="#8FBC8F" class="table table-striped">
	
		<tr>
			<b>
			<th><center>File ID</center></th>
			<th><center>File Description</center></th>
			<th><center>File_Type</center></th>
			<th><center>File Name</center></th>
			<th><center>View</center></th>
			<th><center>DELETE</center></th>
			</b>			
		</tr>
		
		<tr>
			<%
				List<FileBean> fileList = (List<FileBean>)request.getAttribute("fileList");
				if(fileList != null){
					
					for(int i=0 ; i<fileList.size() ; i++){
						
						FileBean fileBean = fileList.get(i);
						//System.out.println(fileBean.getFile_id());
						
						//System.out.println(fileBean.getSub_name());
						
																		
			%>
			
			<td><center><%=fileBean.getFile_id()%></center></td>
			<td><center><%=fileBean.getFile_desc()%></center></td>
			<td><center><%=fileBean.getFile_type()%></center></td>
			<td><center><%=fileBean.getFile_name()%></center></td>
			<%-- <td><img src="../Common_file/<%=fileBean.getFile_name() %>"></td>	 --%>		
			<td><center><a class="delete" href = "admin/DisplayFile.jsp?file_name=<%=fileBean.getFile_name()%>&file_type=<%=fileBean.getFile_type()%>" style="text-decoration:none" target="_blank" rel="noopener noreferrer">   VIEW  </a></scenter></td>
		  	<td><center><a class="update" href = "Login.jsp?semail=<%=fileBean.getFile_id()%>" style="text-decoration:none">   DELETE   </a></center></td>
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