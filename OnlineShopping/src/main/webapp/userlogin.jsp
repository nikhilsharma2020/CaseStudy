<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link href="main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp" %>
	<main>
	<form action="./signIn" method="post">
		Enter UserName : <input type="text" name="uname"><br>
		<br> Enter Password : <input type="password" name="pwd"><br>
		<br> <input type="submit" value="SignIn">
	</form><br><br>
	<a href="usersignup.jsp">New User? SignUp Here</a><br><br>
	</main>
	<%@ include file="footer.jsp" %>
</body>
</html>