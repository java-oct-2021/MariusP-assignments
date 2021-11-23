
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>

<body>
<div id = "container">
<h1>What is your question?</h1>
	<form:form action="/questions/new/submit" method="post" modelAttribute="newquestion">
		<div class = "form-group">
		    <h3>
		        <form:label path="question">Question: </form:label>
		        <form:errors class = "text-danger" path="question"/>
		        <form:textarea path="question"/>
		    </h3>
	    </div>
	    <div class = "form-group">
	    	<h3>
	    		<form:label path = "tag">Tags:  </form:label>
	    		<form:errors class = "text-danger" path = "tag"/>
	    		<form:input path = "tag" />
	    	</h3> 
	    </div>
		    
	    <br>
	    
	    <br>
	    <button type="submit" class = "btn btn-primary" value="Submit">Submit</button>
	</form:form>
	    <br>
	    <br>
	    <h3>Random testing of the importation of a Star Wars API:</h3>
	    <div id="container-fluid">
		<div class="row justify-content-center">
			<div class="col-6">
				<form action="/character" method="GET">
					<select class="form-control" name="id">
						<c:forEach var="character" items="${characters}" varStatus="loop">
							<option value="${loop.index + 1}">${character.name}</option>
						</c:forEach>
					</select>
					<button class="btn btn-success">Get Character</button>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>