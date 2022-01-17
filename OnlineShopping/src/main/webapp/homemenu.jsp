<%@page import="com.basha.bean.Users"  %>
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
		<%@ include file="header.jsp" %>
		<h2>Welcome, ${sessionScope.user1.name.toUpperCase()}!</h2>
	</header>
	<nav>
		<a href="./listofallproduct">List of Products</a><br><br>
		<a href="./buy">Buy Products</a><br><br>
		<form action="">
		<input type="submit" value="Log Out">
		</form>
	</nav>
	<%@ include file="footer.jsp" %>
</body>
</html>