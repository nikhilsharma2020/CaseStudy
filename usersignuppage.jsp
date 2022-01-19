<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link href="style.css" rel="stylesheet">
</head>
<style>
h1{
color: black;
}
</style>
<body>
<center>
<h1>User Sign Up</h1>
</center>
			
		
<div class="form-box">
	
		<main>
	<form action="./userloginpage" method="post">
	    Enter Name : <input type="text" name="name">
	    Enter Mobile Number : <input type="text" name="number">
		Enter UserName : <input type="text" name="uname">
		<br> Enter Password : <input type="password" name="pwd">
		<br> <input type="submit" value="SignUp">
		<button><a href=""> Back to Login Page </a></button>
	</form>
	</main>
	</div>
	
</body>
</html>