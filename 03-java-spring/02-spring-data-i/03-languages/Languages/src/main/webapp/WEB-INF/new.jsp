<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Language</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/new.css"/>
</head>
<body>
<div id = "container">
	<p id = "dashboard"><a href="/dashboard">Dashboard</a></p>
	<p>LANGUAGE NAME:  "${language.name}"</p>
	<p>CREATOR:  "${language.creator}"</p>
	<p>LANGUAGE VERSION "${language.version}"</p>
	<a href="/languages/delete/${language.id}">Delete</a>
	<br>
	<br>
	<a href="/languages/edit/${language.id}">Edit</a>
</div>
</body>
</html>