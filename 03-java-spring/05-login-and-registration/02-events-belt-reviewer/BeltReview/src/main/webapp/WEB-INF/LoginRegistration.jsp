<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login Registration</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Welcome</h1>
	<h3>Register:</h3>

    
    <form:form method="POST" action="/registration/submit" modelAttribute="user">
        <p>
            <form:label path="firstname">First Name:</form:label>
            <form:errors class = "text-danger" path = "firstname"/>
            <form:input type="text" path="firstname"/>
        </p>
        <p>
            <form:label path="lastname">Last Name:</form:label>
            <form:errors class = "text-danger" path = "lastname"/>
            <form:input type="text" path="lastname"/>
        </p>
        <p>
            <form:label path="email">Email:</form:label>
            <form:errors class = "text-danger" path = "email"/>
            <form:input type="text" path="email"/>
        </p>
        <p>
            <form:label path="city">City:</form:label>
            <form:errors class = "text-danger" path = "city"/>
            <form:input type="text" path="city"/>
        </p>
        <p>
            <form:label path="state">State:</form:label>
            <form:errors class = "text-danger" path = "state"/>
            <form:input type="text" path="state"/>
      
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:errors class = "text-danger" path = "password"/>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="confirmpassword">Password Confirmation:</form:label>
            <form:errors class = "text-danger" path = "confirmpassword"/>
            <form:password path="confirmpassword"/>
        </p>
        <input type="submit" value="Register!"/>
    
    </form:form>
    <br>
    <h3>Login:</h3>
    <form:form method="POST" action="/login" modelAttribute="user">
    	<c:out value = "${error}"/> 
     	<p>
            <form:label path="email">Email:</form:label>
            <form:input type="text" path="email"/>
        </p>
    	<p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <input type="submit" value="Login!"/>
     </form:form>
</body>
</html>