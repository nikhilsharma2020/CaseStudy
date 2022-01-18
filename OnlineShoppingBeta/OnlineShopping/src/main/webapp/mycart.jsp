<%@page import="com.basha.bean.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.basha.bean.Users"%>
<%@page import="com.nava.bean.Itoms"%>
<%@page import="com.nava.bean.ItomsList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function refresh() {
	 if (confirm("Refresh...!") == true) {
		 location.replace("http://localhost:8085/OnlineShopping/MyCart");
		  } else {
		  }
	
}
function deleteOne() {
	if (confirm("Delete Product From Cart...!") == true){
		location.replace("http://localhost:8085/OnlineShopping/DeleteProductFromCart");
	}
	}
function deleteAll() {
	if (confirm("Delete All Product From Cart...!") == true){
		location.replace("http://localhost:8085/OnlineShopping/DeleteAllProductFromCart");
	}
}
</script>
</head>
<body>
	<%@ include file="header.jsp" %>
	<br>
	<h2>Here is List of Products Added In Cart</h2>
	<button onclick="refresh()">Refresh</button><br><br>
	<main>
		<table border="1">
			<thead>
				<tr>
					<th>PRODUCT ID</th>
					<th>PRODUCT CODE</th>
					<th>PRODUCT NAME</th>
					<th>DESCRIPTION</th>
					<th>PRODUCT PRICE</th>
					<th>QUANTITY</th>
					<th>TOTAL PRICE</th>
					<th> DELETE</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${sessionScope.cartlist}" var="cartlist">
					<c:forEach items="${sessionScope.productlist}" var="productlist">
						<c:if test = "${productlist.code==cartlist.itoms}">
							<tr>
								<td>${productlist.id}</td>
								<td>${productlist.code}</td>
								<td>${productlist.name}</td>
								<td>${productlist.description}</td>
								<td>${productlist.price}</td>
								<td>${cartlist.quantity}</td>
								<td>${productlist.price*cartlist.quantity}</td>
								<td><form action="./DeleteProductFromCart" method="post">
								<input type="text" name="itom" value="${productlist.code}" hidden="">
									<input type="text" name="quantity" placeholder="1">
									<input type="submit" value="Delete From Cart" >
											</form></td>
							</tr>
						</c:if>
					</c:forEach>
				</c:forEach>
			</tbody>
		</table><br>
		<form action="./DeleteAllProductFromCart" method="get">
		<input type="submit" value="Delete All Itoms From Cart" >
		</form>
		<br> <br>
		<a href="./listofallproduct">Add More Products</a><br>
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