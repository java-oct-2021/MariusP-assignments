<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>Welcome, <c:out value = "${person.firstname}" /></h1>
	<h3>Here are some of the events in your state:</h3>
	<table class = "table table-bordered">
    <thead>
        <tr>
            <th scope = "col">Name</th>
            <th scope = "col">Date</th>
            <th scope = "col">Location</th>
            <th scope = "col">Host</th>
            <th scope = "col">Action/Status</th>
        </tr>
    </thead>
    <tbody>
     	<c:forEach items="${allevents}" var="oneevent">    
    	<tr>
    		<td><c:out value="${oneevent.eventname}"/></td>
    		<td><c:out value="${oneevent.eventdate}"/></td>
    		<td><c:out value="${oneevent.eventcity} ${oneevent.eventstate}"/></td>
    		<td><c:out value = "${person.firstname}"/></td>
    		<td></td>
    	</tr>
    	</c:forEach>
    </tbody>
    </table>
    <br>
    <h3>Here are some of the events in other states:</h3>
    <table class = "table table-bordered">
    <thead>
        <tr>
            <th scope = "col">Name</th>
            <th scope = "col">Date</th>
            <th scope = "col">Location</th>
            <th scope = "col">Host</th>
            <th scope = "col">Action</th>
        </tr>
    </thead>
    <tbody>
    	
    	<tr>
    		<td></td>
    		<td></td>
    		<td></td>
    		<td></td>
    		<td></td>
    	</tr>
    </tbody>
    </table>
    <br>
    <form:form method="POST" action="/event/create/${person.id}" modelAttribute="newevent">
     	<p>
            <form:label path="eventname">Name:</form:label>
            <form:errors class = "text-danger" path = "eventname"/>
            <form:input type="text" path="eventname"/>
        </p>
        <p>
            <form:label path="eventdate">Date:</form:label>
            <form:errors class = "text-danger" path = "eventdate"/>
            <form:input type="text" path="eventdate"/>
        </p>
        <p>
            <form:label path="eventcity">Location:</form:label>
            <form:errors class = "text-danger" path = "eventcity"/>
            <form:input type="text" path="eventcity"/>
        </p>
        <p>
            <form:label path="eventstate">State:</form:label>
            <form:errors class = "text-danger" path = "eventstate"/>
            <form:input type="text" path="eventstate"/>
        </p>
        <form:input type = "hidden" value = "${person.id}" path="person"/>
        <input type="submit" value="Create Event!"/>
    </form:form>
    
</body>
</html>