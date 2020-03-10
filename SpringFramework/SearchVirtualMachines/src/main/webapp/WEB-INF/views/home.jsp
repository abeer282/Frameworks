<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html>
<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
		<meta charset="ISO-8859-1">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<a href='viewVM'>view</a>
<a href='addVM'>add</a>
<P>  The time on the server is ${serverTime}. </P>

		<div class="container">
				<div class="jumbotron">
					<form:form method='post' action='home' class='form-group'>
					<table class=table-bordered width='90%'>
						<tr>
							<td>id:</td>
							<td> <form:input path='id' class='form-control'/> </td>
						</tr>
						
						<tr>
							<td>name:</td>
							<td><form:input path='name' class='form-control'/> </td>
						</tr>
						<tr>
							<td>password:</td>
							<td><form:input path='password' class='form-control'/> </td>
						</tr>
						<tr>
							<td colspan='2'><input type='submit' value='submit' class='form-control'/> </td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
		
</body>
</html>
