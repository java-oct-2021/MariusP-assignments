<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Date"%>

    
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>DojoSurvey</title>
<link rel="stylesheet" type="text/css" href="css/indexstyle.css">
<script type="text/javascript" src="js/app.js"></script>
</head>


<body>
	<h1> Welcome to the Coding Dojo Survey!</h1>
	<div id = "container">
		<form action = "/result">
			<h3>Name: <input type = "text" name = "fname"></h3>
			<br>
			<h3>Dojo Location: 
				<select name = "location">
					<option value = "Chicago">Chicago</option>
					<option value = "San Jose">San Jose</option>
					<option value = "Seattle">Seattle</option>
					<option value = "San Francisco">San Francisco</option>
				</select>
			</h3>
			<br>
			<h3>Favorite Language: 
			<select name = "language">
					<option value = "Python">Python</option>
					<option value = "C++">C++</option>
					<option value = "Java">Java</option>
					<option value = "Ruby">Ruby</option>
				</select>
			</h3>
			<br>
			<h3>Comments:
			<br> 
				<textarea name = "comments" cols = "25" rows = "5">
				</textarea>
			</h3>		
		<button>Result</button>
		</form>
	</div>
</body>
</html>