<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>logout page</title>
</head>
<body>
	<header>
		<h1>Basha Online Shopping</h1> <br>	
		
	</header>
	<nav>
	<h2>Thank You Visiting, <%String message=(String)session.getAttribute("message");
		out.println(message);%> !</h2> 
		<br> <br>
		<a href="./userlogin.jsp">Sign in Again</a><br><br>
	</nav>
	<footer>
		<h5>Copyright content of Basha pvt.limited&copy;</h5>
		<h6>Registered With govt.of.India &reg; </h6>
	</footer>
</body>
</html>