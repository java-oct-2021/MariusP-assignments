<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/edit.css"/>
</head>
<body>
<div id = "container">
	<a href="/dashboard"><p class = "top"> Dashboard </p></a>
	<a href="/languages/delete/${edit.id}"><p class = "top"> Delete </p></a>
	<form:form action="/languages/update/${edit.id}" method="post" modelAttribute="EditLanguage">
	    <input type="hidden" name="_method" value="put">
	    <p>
	        <form:label path="Name">Name</form:label>
	        <form:errors path="Name"/>
	        <form:input path="Name" value = "${edit.name}"/>
	    </p>
	    <p>
	        <form:label path="Creator">Creator</form:label>
	        <form:errors path="Creator"/>
	        <form:input path="Creator" value = "${edit.creator}"/>
	    </p>
	    <p>
	        <form:label path="Version">Version</form:label>
	        <form:errors path="Version"/>
	        <form:input path="Version" value = "${edit.version}"/>
	    </p> 
	    <input type="submit" class = "btn btn-secondary" value="Submit"/>
	</form:form>
</div>
</body>
</html>