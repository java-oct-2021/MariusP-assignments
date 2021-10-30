<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/newninja.css"/>
</head>

<body>
<div id = "container">
<h1>New Ninja</h1>
<div id = "form"> 
	<form:form action="/ninjas/new/create" method="post" modelAttribute="ninja">
    <div class = "form-group">
    		<form:label path = "dojo"><h3>Dojo (Select from drop-down menu):</h3></form:label>
    		<form:errors class = "text-danger" path="dojo"/>
    		<form:select class = "form-control" path = "dojo">
    			<c:forEach items ="${Dojos}" var = "Dojo">
    				<option value = "${Dojo.id}">${Dojo.dojo}</option>
    			</c:forEach>
    		</form:select>
    </div>
    <br>
    <br>
    <div class = "form-group">
	    <h3>
	        <form:label path="FirstName">First Name</form:label>
	        <form:errors class = "text-danger" path="FirstName"/>
	        <form:input path="FirstName"/>
	    </h3>
    </div>
    <br>
    <div class = "form-group">
	    <h3>
	        <form:label path="LastName">Last Name</form:label>
	        <form:errors class = "text-danger" path="LastName"/>
	        <form:input path="LastName"/>
	    </h3>
    </div>
    <br>
    <div class = "form-group">
	    <h3>
	        <form:label path="Age">Age</form:label>
	        <form:errors class = "text-danger" path="Age"/>
	        <form:input path="Age"/>
	    </h3> 
	</div>
	<br>
    <button type="submit" class = "btn btn-primary" value="Submit">Create</button>
	</form:form> 
	</div>

</div>


</body>
</html>