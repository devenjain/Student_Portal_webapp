<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View</title>

<style>

	.manageMainBody{
		margin-left: 45px;
		margin-top:50px;
		margin-right : 10px;
	}

</style>

</head>
<body>
<%@include file="adminHeader.jsp" %>
<div class = "manageMainBody">
	
	<%
		String file_name = request.getParameter("file_name");
		String file_type = request.getParameter("file_type");
		System.out.println("FIle name  : " + file_name);
		System.out.println("FIle type  : " + file_type);
		
		if(file_type.equalsIgnoreCase("image/jpeg") || file_type.equalsIgnoreCase("image/png")){		
	%>
	
		<center><img src = "../Common_File/<%=file_name %>" width="80%" height="575"></center>
	
	<%
		}
		else if(file_type.equalsIgnoreCase("application/pdf")){
	%>
		<center><embed src = "../Common_File/<%=file_name %>" width="100%" height="575" /></center>
	<%} %>
	
</div>
</body>
</html>