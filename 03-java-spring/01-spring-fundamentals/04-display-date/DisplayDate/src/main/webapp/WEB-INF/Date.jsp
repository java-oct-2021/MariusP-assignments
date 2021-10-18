<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date" import = "java.text.DateFormat" 
    import = "java.text.ParseException"  import = "java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Date</title>
<link rel="stylesheet" type="text/css" href="css/datestyle.css">
<script type="text/javascript" src="js/Javas.js"></script>
</head>

<body>
<div id = "header">
	<h1>The date is: <c:out value = "${formatter}"/></h1>
</div>

</body>
</html>