<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp Page</title>
<link href="main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp" %>
	<main>
	<form action="./signup" method="post">
	    Enter Name : <input type="text" name="name"><br>
	    Enter Mobile Number : <input type="text" name="number"><br>
		Enter UserName : <input type="text" name="uname"><br>
		<br> Enter Password : <input type="password" name="pwd"><br>
		<br> <input type="submit" value="SignUp">
	</form>
	</main>
	<%@ include file="footer.jsp" %>
</body>
</html>