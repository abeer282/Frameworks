<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
		<meta charset="ISO-8859-1">
		<title>VIEW</title>
	</head>
	<body>
		<div class="container">
				<div class="jumbotron">
					<form:form method='post' action='viewVM' class='form-group'>
					
					<table class=table-bordered width='100%' border='1' cellpadding='1'>
						<tr><th>ID</th> <th>IP</th> <th>USERNAME</th> <th>PASSWORD</th>  <th>PATH</th><th>other</th> </tr>
						<c:forEach var="vm" items="${list}">
							<tr> 
								<td> ${vm.ID}</td>
								<td> ${vm.IP}</td>
								<td> ${vm.userName}</td>
								<td> ${vm.password}</td>
								<td> ${vm.path}</td>
								<td> 
										      <form:form method = "GET" action = "viewVM">
										         <table>
										            <tr>
										               <td>
										                  <input type = "submit" value = "search"/>
										               </td>
										            </tr>
										         </table>  
										      </form:form>
								
								</td>
							</tr>
						</c:forEach>
					</table>
				</form:form>
				</div>
			</div>
	</body>
</html>