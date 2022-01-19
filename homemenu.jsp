<%@page import="com.purba.bean.Users"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<style>
body{
background-image: url("9c44586e92284ae7903d.jpg");
background-size: 100%;
}
</style>
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