
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions List</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>

<body>
<div id = "container">
	<h1>Questions Dashboard</h1>
	<table class = "table table-bordered">
    <thead>
        <tr>
            <th scope = "col">Question</th>
            <th scope = "col">Tags</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${questions}" var="item">
        <tr class = "table-striped">
        <td><a href = "/questions/${item.id}"><c:out value="${item.question}"/></a><td>
        	<c:forEach items="${item.tags}" var="line">
        		<td><c:out value="${line.subject}"/></td>
       		</c:forEach>
        </tr>
        </c:forEach>    
    </tbody>
	</table>
	<br>
	<a href = "/questions/newquestion">New Question</a>
</div>
</body>
</html>