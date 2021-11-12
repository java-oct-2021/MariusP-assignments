<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Event id</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1>${event.eventname}</h1>
	<br>
	<p>Host: ${event.person.firstname}</p>
	<p>Date: ${event.eventdate} </p>
	<p>Location: ${event.eventcity},${event.eventstate} </p>
	<p>People who are attending this event: ${mypersons.size()} </p>
	<br>
	<table class = "table table-bordered">
    <thead>
        <tr>
            <th scope = "col">Name</th>
            <th scope = "col">Location</th>
        </tr>
    </thead>
    <tbody>
   		<c:forEach items="${mypersons}" var="oneattendant">
	    	<tr>
	    		<td><c:out value = "${oneattendant.firstname} ${oneattendant.lastname}"/></td>
	    		<td><c:out value = "${oneattendant.city} ${oneattendant.state}"/></td> 
	    	</tr>
	    </c:forEach>
    </tbody>
    </table>
    <br>
    
    <table class = "table table-bordered">
    <thead>
        <tr>
            <th scope = "col">Message Wall:</th>
        </tr>
	</thead>
	<tbody>
		<c:forEach items="${mydiscussions}" var="discussion">   
		<tr>
			<td><c:out value = "${discussion.submission}"/></td>
		</tr>
		</c:forEach>
	</tbody>
  	</table>
    <form:form method="POST" action="/event/discussion/${event.id}" modelAttribute="eventdescribe">
        <form:label path="submission">Add Discussion: </form:label>
        <form:errors class = "text-danger" path="submission"/>
        <form:textarea path="submission"/>
        <br>
        <br>
        <input type="submit" value="Submit"/>
    </form:form>
 
	
</body>
</html>