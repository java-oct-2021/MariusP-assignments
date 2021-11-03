<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Category</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/categoryid.css"/>
</head>
<body>
<div id = "container">
	<h1>"${category.name}"</h1>
	<br>
	<table class = "table table-primary">
    <thead>
        <tr>
            <th scope = "col">Products:</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${category.products}" var="subject">
        <tr>
            <th scope = "row"><c:out value="${subject.name}"/></th>
            <br>
        </tr>
        </c:forEach>
    </tbody>
	</table>
	<br>
    <br>
    <h3>Select to add a product for this category:</h3>
    <form action="/products/${category.id}" method="post">
    	<div class = "form-group">
    		<label><h3>Category:</h3></label>
    		<select class = "form-control" name = "product">
    			<c:forEach items ="${someproducts}" var = "subject">
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