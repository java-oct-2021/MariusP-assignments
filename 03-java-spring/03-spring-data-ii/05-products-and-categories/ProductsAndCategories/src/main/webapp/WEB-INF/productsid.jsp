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
<link rel="stylesheet" href="/productsid.css"/>
</head>
<body>
<div id = "container">
	<h1>"${product.name}"</h1>
	<br>
	<h3>Description: </h3><p>"${product.description}"</p>
	<h3>Price: </h3><p>"${product.price}"</p>
	<h3>Categories:</h3>
	<br>
	<c:forEach items="${product.categories}" var="item">
        <c:out value="${item.name}"/>
        <br>
    </c:forEach>
    <br>
    <br>
    <h3>Select to add a category for this product:</h3>
    <form action="/categories/${product.id}" method="post">
    	<div class = "form-group">
    		<label><h3>Category:</h3></label>
    		<select class = "form-control" name = "category">
    			<c:forEach items ="${somecategories}" var = "subject">
    				<option value = "${subject.id}">"${subject.name}"</option>
    			</c:forEach>
    		</select>
    	<br>
    	<button type="submit" class = "btn btn-primary" value="Submit">Create</button>	
    	</div>
    </form>
    <br>
</div>
</body>
</html>