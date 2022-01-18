<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login error</title>
</head>
<body>

	<header>
		<h1>Basha Online Shopping</h1>
	</header> 
	<main>
		<h3><%String message=(String)session.getAttribute("message");
		out.println(message);%></h3> <br>
		
		<a href="./usersignup.jsp">Sign Up Again</a>
	</main> <br> <br> <br>
	<footer>
		<h5>Copyright content of Basha pvt.limited&copy; </h5>
		<h6>Registered With govt.of.India &reg; </h6>
	</footer>
</body>
</html>