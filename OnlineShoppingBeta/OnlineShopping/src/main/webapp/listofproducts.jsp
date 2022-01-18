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
<script type="text/javascript">
function addToCart() {
	if (confirm("Add to Cart...") == true){
		location.replace("http://localhost:8085/OnlineShopping/AddProductInCart");
	}	
	}
</script>
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
					<th>* cart *</th>
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
						<td><form action="./AddProductInCart" method="post">
									<input type="text" name="itom" value="${productlist.code}" hidden=""  >
									<input type="text" name="quantity" placeholder="1">
									<input type="submit" value="Add To Cart" >
											</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table><br>
		<a href="./MyCart">Go To My Cart</a>
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