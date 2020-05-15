<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServeletController" method="post">
<!-- 	user name -->
<label for="username">Username</label>
<input type="text" placeholder="Enter Username" name="usuario">

<!-- 	password -->
<label for="password">Password</label>
<input type="password" placeholder="Enter Password" name="contrasenia">

<input type="submit" value="Log In" >
</form>
</body>
</html>