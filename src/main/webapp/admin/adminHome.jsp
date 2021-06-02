<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DashBoard</title>

    <style>

.manageMainBody{
margin-left: 45px;
margin-top:50px;
margin-right : 10px;
}

body {
    background-image: url('images/adminbg3.jpg');
    height: 40vh;
    background-repeat: no-repeat;
    background-position: center;
    background-size: cover;
    position: relative;
    margin-left: 40px;
} 

.one{
    position: relative;
    margin: 40px;
    width: 200px;   
    height: 230px;
   /*  background-color: darkgrey; */
    /* background: url('../images/faculty_image.jpg');  */
    transition: 1s;
    text-align: center;
    /* line-height: 200px; */
    font-size: 16px;
    float: left;
}
.one::before{
    content: 'Faculty';
    color: black;
    left: 0;
    width: 200px;
    height: 60px;
    position: absolute;
    opacity: 0;
    text-align: center;
    line-height: 60px;
    transition: .4s;
    /* font-size: 35px; */
}
.one:hover::before{
    opacity: 1;
    background: linear-gradient(grey,white);
    transform: translateY(230px) scale(1.1);
}
.two{
    position: relative;
    margin: 40px;
    width: 200px;   
    height: 230px;
    /* background-color: darkgrey; */
   /*  background: url('../images/student_image.jpg');  */
    transition: 1s;
    text-align: center;
    /* line-height: 200px; */
    font-size: 16px;
    float: left;
}
.two::before{
    content: 'Student';
    color: black;
    left: 0;
    width: 200px;
    height: 60px;
    position: absolute;
    background-position: center;
    background-repeat: no-repeat;
    opacity: 0;
    text-align: center;
    line-height: 60px;
    transition: .4s;
  
}
.two:hover::before{
    opacity: 1;
    background: linear-gradient(grey,white);
    transform: translateY(230px) scale(1.1);
}
.three{
    position: relative;
    margin: 40px;
    width: 200px;   
    height: 230px;
   /*  background-color: darkgrey; */
   /*  background: url('../images/Subject_image.jpg'); */
    transition: 1s;
    text-align: center;
    /* line-height: 200px; */
    font-size: 16px;
    float: left;
}
.three::before{
    content: 'Subjects';
    color: black;
    left: 0;
    width: 200px;
    height: 60px;
    position: absolute;
    opacity: 0;
    text-align: center;
    line-height: 60px;
    transition: .4s;
}
.three:hover::before{
    opacity: 1;
    background: linear-gradient(white,grey);
    transform: translateY(230px) scale(1.1);
}
.four{
    position: relative;
    margin: 40px;
    width: 200px;   
    height: 230px;
   /*  background-color: darkgrey; */
   /* background: url('c1.jpg'); */
    transition: 1s;
    text-align: center;
    /* line-height: 200px; */
    font-size: 16px;
    float: left;
}
.four::before{
    content: 'Files';
    color: black;
    left: 0;
    width: 200px;
    height: 60px;
    position: absolute;
    opacity: 0;
    text-align: center;
    line-height: 60px;
    transition: .4s;
}
.four:hover::before{
    opacity: 1;
    background: linear-gradient(grey,white);
    transform: translateY(230px) scale(1.1);
}

    </style>

</head>
<body style = "background-color : #D5DBDB">
<div class = "manageMainBody">

   	<%@include file="adminHeader.jsp" %>

    	<div class="welcome">
		<center><h1>Welcome</h1></center>
    	</div>
	<hr>
    	<br>
    	<div class="one">
    		<a href="../StudentListController"><img src="../images/faculty_image.jpg" width="200" height="230"></a>
    	</div>
    	
    	<div class="two">
    		<a href="../FacultyListController"><img src="../images/student_image.jpg" width="200" height="230"></a>
    	</div>
    	
    	<div class="three">
    		<a href="../SubjectListController"><img src="../images/Subject_image.jpg" width="200" height="230"></a>
    	</div>
    	
    	<div class="four">
    		<a href="../FileListController"><img src="../images/file_image.png" width="200" height="230"></a>
    	</div>
    <!-- <div class="four"></div> -->
    
</div>
</body>
</html>