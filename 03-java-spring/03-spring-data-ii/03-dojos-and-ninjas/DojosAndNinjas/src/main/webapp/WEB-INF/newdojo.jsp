<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/newdojo.css"/>
</head>
<body>

<div id = "container">
	<h1>New Dojo</h1>
	<br>
	<br>
	<form:form action="/dojos/new/create" method="post" modelAttribute="dojo">
	<div class = "form-group">
	    <h3>
	        <form:label path="Dojo">Name</form:label>
	        <form:errors class = "text-danger" path="Dojo"/>
	        <form:input path="Dojo"/>
	        <input type="submit" class = "btn btn-primary" value="Submit"/>
	    </h3>
    </div>
    </form:form>
</div>

</body>
</html>