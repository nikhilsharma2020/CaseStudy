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
<header><h1>Basha Online Shopping</h1></header>
<br>
<h2>You Selected This Item</h2>

	<%-- <c:forEach items="${sessionScope.productlist}" var="productlist">
		<h4>Name: ${productlist.name} </h4>
		<h4>About: ${productlist.description}</h4>
		<h4>Price: ${productlist.price}</h4>

	</c:forEach>--%>
	<h4>Name: ${sessionScope.productlist.name}</h4>
	<h4>About: ${sessionScope.productlist.description}</h4>
	<h4>Price: ${sessionScope.productlist.price}</h4>
<form action="./bill?product=${sessionScope.productlist.code}"method="get">
<input type="submit" value="Buy">
</form>


<footer>
		<h5>Copyright content of Basha pvt.limited&copy;</h5>
		<h6>Registered With govt.of.India &reg;</h6>
	</footer>
</body>
</html>