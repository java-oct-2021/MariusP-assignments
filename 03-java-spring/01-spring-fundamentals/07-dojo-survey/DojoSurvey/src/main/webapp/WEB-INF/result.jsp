<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>DojoSurvey</title>
<link rel="stylesheet" type="text/css" href="css/resultsstyle.css">
<script type="text/javascript" src="js/app.js"></script>
</head>
	
<body>
	<h1> Survey Results!</h1>
	<div id = "container"> 
		<h3>Submitted info: </h3> <p> <c:out value = "${fname}"/></p>
		<br>
		<h3>Dojo Location: </h3> <p> <c:out value = "${location}"/></p>
		<br>
		<h3>Language: </h3> <p> <c:out value = "${language}"/></p>
		<br>
		<h3>Comments: </h3> <p> <c:out value = "${comments}"/></p>
		<br>
		<br>
		<form action = "/submit">
		<button>Go Back</button>
		</form>
	</div>
</body>

</html>