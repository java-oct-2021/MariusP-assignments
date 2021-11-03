<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/categorynew.css"/>
</head>
<body>
<div id = "container">
<table class = "table table-primary">
    <thead>
        <tr>
            <th scope = "col">Category</th>
            <th scope = "col">View category</th>
            <th score = "col">Delete category</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${categories}" var="item">
        <tr>
            <th scope = "row"><c:out value="${item.name}"/></th>
            <td><a href = "${item.id}">View</a></td>
            <td><a href = "${item.id}/delete">Delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
	</table>

<h1>New Category</h1>

<form:form action="/categories/new/create" method="post" modelAttribute="category">
	<div class = "form-group">
	    <h3>
	        <form:label path="name">Name: </form:label>
	        <form:errors class = "text-danger" path="name"/>
	        <form:input path="name"/>
	    </h3>
    </div>
    <br>
	<br>
    <button type="submit" class = "btn btn-primary" value="Submit">Create</button>
</form:form> 
</div>

</body>
</html>