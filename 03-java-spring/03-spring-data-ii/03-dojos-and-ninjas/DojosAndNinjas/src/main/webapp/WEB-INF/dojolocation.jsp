<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Location</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/dojolocation.css"/>
</head>
<body>
<h1>"${location.dojo}" Location Ninjas</h1>
<div id = "container">
	<table class = "table table-primary">
    <thead>
        <tr>
            <th scope = "col">First Name</th>
            <th scope = "col">Last Name</th>
            <th scope = "col">Age</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${location.ninjas}" var="Ninja">
        <tr>
            <th scope = "row"><c:out value="${Ninja.firstName}"/></th>
            <td><c:out value="${Ninja.lastName}"/></td>
            <td><c:out value="${Ninja.age}"/></td>
        </tr>
        </c:forEach>
    </tbody>
	</table>

</div>

</body>
</html>