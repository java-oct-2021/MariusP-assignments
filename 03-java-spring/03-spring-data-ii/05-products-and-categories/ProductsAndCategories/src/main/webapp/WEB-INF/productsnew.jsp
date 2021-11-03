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
<link rel="stylesheet" href="/productsnew.css"/>
</head>
<body>
<div id = "container">
<table class = "table table-primary">
    <thead>
        <tr>
            <th scope = "col">Product</th>
            <th scope = "col">View category</th>
            <th score = "col">Delete category</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${products}" var="product">
        <tr>
            <th scope = "row"><c:out value="${product.name}"/></th>
            <td><a href = "${product.id}">View</a></td>
            <td><a href = "${product.id}/delete">Delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
	</table>

<h1>New Product</h1>
<form:form action="/products/new/create" method="post" modelAttribute="product">
	<div class = "form-group">
	    <h3>
	        <form:label path="name">Name: </form:label>
	        <form:errors class = "text-danger" path="name"/>
	        <form:input path="name"/>
	    </h3>
    </div>
    <br>
    <div class = "form-group">
	    <h3>
	        <form:label path="description">Description: </form:label>
	        <form:errors class = "text-danger" path="description"/>
	        <form:textarea path="description"/>
	    </h3>
    </div>
    <br>
    <div class = "form-group">
	    <h3>
	        <form:label path="price">Price: </form:label>
	        <form:errors class = "text-danger" path="price"/>
	        <form:input path="price"/>
	    </h3> 
	</div>
	<br>
    <button type="submit" class = "btn btn-primary" value="Submit">Create</button>
</form:form> 
</div>

</body>
</html>