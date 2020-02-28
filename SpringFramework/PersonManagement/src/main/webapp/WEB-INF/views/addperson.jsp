<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>ADD</h1>
<div class='form-group'>

<form:form method='post' action='save'> <!-- action save= go to controller and find end point == to save -->
<table class='form-group'>

<tr>
<td>First name</td>
<td><form:input path='fname' class='form-control'/></td>
</tr>

<tr>
<td>Last name</td>
<td><form:input path='lname' class='form-control'/></td>
</tr>

<tr>
<td>Age</td>
<td><form:input path='age' class='form-control'/></td>
</tr>

<tr>
<td>height</td>
<td><form:input path='height' class='form-control'/></td>
</tr>

<tr>
<td>weight</td>
<td><form:input path='weight' class='form-control'/></td>
</tr>

<tr>
<td>Gender</td>
<td><form:input path='gender' class='form-control'/></td>
</tr>

<tr>
<td>phone</td>
<td><form:input path='phone' class='form-control'/></td>
</tr>

<tr>
<td>email</td>
<td><form:input path='email' class='form-control'/></td>
</tr>

<tr>
<td>city</td>
<td><form:input path='city' class='form-control'/></td>
</tr>

<tr>
<td>country</td>
<td><form:input path='country' class='form-control'/></td>
</tr>


</table>



</form:form>



</div>




</body>
</html>