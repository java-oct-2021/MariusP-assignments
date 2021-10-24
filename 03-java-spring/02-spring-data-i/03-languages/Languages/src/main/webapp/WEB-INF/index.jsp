<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>    

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Language List</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/index.css"/>
</head>

<body>
<div id = "container">
	<table class = "table table-primary">
    <thead>
        <tr>
            <th scope = "col">Name</th>
            <th scope = "col">Creator</th>
            <th scope = "col">Version</th>
            <th scope = "col">Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${languages}" var="language">
        <tr>
            <th scope = "row"><a href = "/languages/${language.id}"><c:out value="${language.name}"/></a></th>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.version}"/></td>
            <td>
			<a href="/languages/edit/${language.id}">Edit</a>
			<a href="/languages/delete/${language.id}">Delete</a>
			</td>
        </tr>
        </c:forEach>
    </tbody>
	</table>
	
	<div id = "form"> 
	<form:form action="/languages/new" method="post" modelAttribute="test">
    <div class = "form-group">
	    <p>
	        <form:label path="Name">Name</form:label>
	        <form:errors path="name"/>
	        <form:input path="Name"/>
	    </p>
    </div>
    <div class = "form-group">
	    <p>
	        <form:label path="Creator">Creator</form:label>
	        <form:errors path="creator"/>
	        <form:input path="Creator"/>
	    </p>
    </div>
    <div class = "form-group">
	    <p>
	        <form:label path="Version">Version</form:label>
	        <form:errors path="version"/>
	        <form:input path="Version"/>
	    </p> 
	</div>
    <input type="submit" class = "btn btn-primary" value="Submit"/>

	</form:form> 
	</div>
</div>   
</body>
</html>