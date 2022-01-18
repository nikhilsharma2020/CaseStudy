<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Basha Online Shopping</h1>
	<br>
	<h2>Select from Here</h2>
	<br>
	<c:forEach items="${sessionScope.productlist}" var="productlist">
	    <a href="./selected?productCode=${productlist.code}">Name: ${productlist.name}</a>	
		<h4>About: ${productlist.description}</h4>
		<h4>Price: ${productlist.price}</h4>
	</c:forEach>
	<footer>
		<h5>Copyright content of Basha pvt.limited&copy;</h5>
		<h6>Registered With govt.of.India &reg;</h6>
	</footer>
</body>
</html>