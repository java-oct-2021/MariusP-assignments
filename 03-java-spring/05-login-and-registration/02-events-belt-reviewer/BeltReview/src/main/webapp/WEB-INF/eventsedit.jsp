<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events edit</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<h1>"${event.eventname}"</h1>
<br>
<br>
<h3>Edit event:</h3>
<br>
<form:form method="POST" action="/event/edit/submit/${event.id}" modelAttribute="editevent">
     	<p>
            <form:label path="eventname">Name:</form:label>
            <form:errors class = "text-danger" path = "eventname"/>
            <form:input type="text" value = "${event.eventname}" path="eventname"/>
        </p>
        <p>
            <form:label path="eventdate">Date:</form:label>
            <form:errors class = "text-danger" path = "eventdate"/>
            <form:input type="date" value = "${event.eventdate}" path="eventdate"/>
        </p>
        <p>
            <form:label path="eventcity">Location:</form:label>
            <form:errors class = "text-danger" path = "eventcity"/>
            <form:input type="text" value = "${event.eventcity}" path="eventcity"/>
        </p>
        <p>
            <form:label path="eventstate">Name:</form:label>
            <form:errors class = "text-danger" path = "eventstate"/>
            <form:input type="text" value = "${event.eventstate}" path="eventstate"/>
        </p>
        <input type="submit" value="Edit"/>
    </form:form>
    
</body>
</html>