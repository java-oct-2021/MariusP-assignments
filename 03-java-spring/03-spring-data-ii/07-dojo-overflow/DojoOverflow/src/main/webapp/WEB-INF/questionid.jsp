
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<h1><c:out value="${question.question}" /></h1>
	<br>
	<h3>Tags: </h3>
	<br>
	<c:forEach items="${question.tags}" var="subject">
         <c:out value="${subject.subject}"/>
         <br>
    </c:forEach>
	<table class = "table table-primary">
	    <thead>
	        <tr>
	            <th scope = "col">Answers</th>
	        </tr>
	    </thead>
	    <tbody>
	        <tr>
	        <c:forEach items="${question.answers}" var="answer">
	            <td><c:out value="${answer.answer}"/></td>
	        </c:forEach>
	        </tr>
	    </tbody>
    </table>
    <h3>Add your answer:</h3>
    <form:form action="/answers/new/${question.id}" method="post" modelAttribute="submitanswer">
		<div class = "form-group">
		    <h3>
		        <form:label path="answer" name = "answer">Answer: </form:label>
		        <form:errors class = "text-danger" path="answer"/>
		        <form:textarea path="answer"/>
		    </h3>
	    </div>
	    <br>
	    
	    <br>
	    <button type="submit" class = "btn btn-primary" value="Submit">Submit</button>
	</form:form>
</body>
</html>