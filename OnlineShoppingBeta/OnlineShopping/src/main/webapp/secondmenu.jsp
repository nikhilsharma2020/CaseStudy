<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link href="main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<header>
		<%@ include file="header.jsp" %> <br>
	<h2><%String message=(String)session.getAttribute("message");
		out.println(message);%></h2> 	
		
	</header>
	<nav>
		<a href="./userlogin.jsp">Sign In</a><br><br>
		<a href="./listofallproduct">List of Products</a><br><br>
	</nav>
			<%@ include file="footer.jsp" %> <br>
</body>
</html>