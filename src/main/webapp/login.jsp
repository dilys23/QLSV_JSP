<%@page import="Controller.C_Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="login.css"> 
</head>
<body>
<%
		String temp="temp";
		session.setAttribute("temp", temp);
	%>
 <form name="form1" method="post" action="C_Student">
    <div class="container">
        <h2>Login</h2>
        <div class="input-container">
            <label for="username">Username</label>
            <input type="text"  name="username">
        </div>
        <div class="input-container">
            <label for="password">Password</label>
            <input type="password"  name="password">
        </div>
        <div class="btn-container">
            <input type="submit" value ="Login">
            
            <input type="reset" id="reset" value="Reset">
        </div>
    </div>
</form>

</body>
</html>