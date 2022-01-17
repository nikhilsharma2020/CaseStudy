<%@page import="com.basha.bean.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.basha.bean.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list of products</title>
<link href="main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.jsp" %>
	<br>
	<h2>Here is List of Products</h2>
	<main>
		<table border="1">
			<thead>
				<tr>
					<th>PRODUCT ID</th>
					<th>PRODUCT CODE</th>
					<th>PRODUCT NAME</th>
					<th>DESCRIPTION</th>
					<th>PRODUCT PRICE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sessionScope.productlist}" var="productlist">
					<tr>
						<td>${productlist.id}</td>
						<td>${productlist.code}</td>
						<td>${productlist.name}</td>
						<td>${productlist.description}</td>
						<td>${productlist.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br> <br>
		<c:choose>
			<c:when test="${sessionScope.user1.userName!=null}">
				<a href="./homemenu.jsp">Go To Main Menu</a>
			</c:when>
			<c:otherwise>
				<a href="./firstmenu.jsp">Go To Main Menu</a>
			</c:otherwise>
		</c:choose>

	</main>

	<%@ include file="footer.jsp" %>

</body>
</html>