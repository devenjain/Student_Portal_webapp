<%@page import="com.admin.dao.AdminDao"%>
<%@page import="com.admin.services.AdminService"%>
<%@page import="com.student.bean.StudentBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>  
<html>  
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>  
<style>  
body{  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: E0FFFF;  
}  
.container {  
    	padding: 80px;  
	background-color: #8FBC8F;  
}  
  
input[type=text], input[type=password], textarea {  
  width: 100%;  
  padding: 15px;  
  margin: 5px 0 22px 0;  
  display: inline-block;  
  border: none;  
  background: #f1f1f1;  
}  

input[type=text]:focus, input[type=password]:focus {  
  background-color:#b0fcb0 ;  
  outline: none;  
}  

/* input[type=date]{
  width: 15%;  
  padding: 10px;  
  margin: 5px 0 22px 10px;  
  display: inline-block;  
  border: none;  
  background: whitesmoke;  
}  

input[type=date]:focus{
  background-color: #b0fcb0 ;  
  outline: none;  
}   */

 div {  
            padding: 10px 0;  
         }
           
hr {  
  border: 1px solid #f1f1f1;  
  margin-bottom: 25px;  
}  
.registerbtn {  
  background-color: #4CAF50;  
  color: white;  
  padding: 16px 20px;  
  margin: 8px 0;  
  border: none;  
  cursor: pointer;  
  width: 100%;  
  opacity: 0.9;  
}  
.registerbtn:hover {  
  opacity: 1;  
}  
p{
color:red;
}

</style>  
</head>  
<body>  

<%@include file="adminHeader.jsp" %>

<%

	/* int sid = Integer.parseInt(request.getParameter("sid"));
	AdminService service = new AdminDao();

	StudentBean studentBean = service.getStudentBean(sid); */

%>

<form action="./UpdateStudentController" method="post">   
  <div class="container">  
    
  <center>  <h1> Student Registeration Form</h1> </center>
  <center>${errormsg1}</center>  
  <hr>  
  
<b>Student ID</b>  &nbsp;&nbsp; <font color = "RED"></font>

<div class= "iphone"><input type="number" name="id" placeholder="student id" size="10" value="${studentBean.sid }" readonly>   </div>
  
  <label> Firstname :</label> ${nameError } 
<input type="text" name="firstname" placeholder= "Firstname" size="15" value="${studentBean.sfname }" required />   

<label> Middlename : </label>   ${nameError }
<input type="text" name="middlename" placeholder="Middlename" size="15" value="${studentBean.smname }" required />   

<label> Lastname : </label>   ${nameError } 
<input type="text" name="lastname" placeholder="Lastname" size="15" value="${studentBean.slname }" required />   

<div>  
<label>   
Gender :  
</label><br><br> 
<input type="radio" value="Male" name="gender" checked > Male   
<input type="radio" value="Female" name="gender"> Female   
<input type="radio" value="Other" name="gender"> Other  
</div>  
<label>   

    <div>
  <label for="example-date-input" class="col-2 col-form-label"><b>BirthDate</b></label>
  <br>
  <div>
    <input class="form-control" type="date" name="dob" value="${studentBean.sdob }" id="example-date-input" min="1997-01-01" max="2003-12-31">
  </div>
</div>  
   
</label>
<br>

<b>Phone : </b> &nbsp;&nbsp; <font color = "RED">${phoneerror}</font>

<div class= "iphone"><input type="text" name="phone" placeholder="phone no." size="10" value="${studentBean.sphone }" required>   </div>


<!-- Current Address :  
<textarea cols="80" rows="5" placeholder="Current Address" value="address" required>   -->
  
 <label for="email"><b>Email</b></label> &nbsp;&nbsp; <font color = "RED">${emailError }</font>
 <input type="text" placeholder="Enter Email" name="email" value="${studentBean.semail }" required>  
  
    <label for="psw"><b>Password</b></label> &nbsp;&nbsp; <font color = "RED">${pwdErrormsg }</font>
    <input type="password" placeholder="Enter Password" name="pwd" value="${upwd}" required>  
  
    <label for="psw-repeat"><b>Re-type Password</b></label>&nbsp;&nbsp; <font color = "RED">${missmatch }</font>
    <input type="password" placeholder="Retype Password" name="pwd-repeat" required>  
    <input type="reset" class="registerbtn"></button>   
    <button type="submit" class="registerbtn">Update</button> 
    
<%--     <%@include file="footer.jsp" %> --%>
       
</form>  
</body>  
</html>  