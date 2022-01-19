<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Page</title>
<link href="style.css" rel="stylesheet">
</head>
<style>
body{
color:black;
}
</style>
<body>
<center><h1>Welcome to Online Shopping! </h1></center>
<div class="form-box">
		<div class="header-text">
			User Login
		</div>
		<input placeholder="Your Email Address" type="text"> <input placeholder="Your Password" type="password"> 
		 <button>Login</button><br><br><br>
		<button><a href="usersignuppage.jsp"> New User? Click to Register</a></button>
		<center><%@ include file="footer.jsp" %></center>
	</div>

</body>
</html>