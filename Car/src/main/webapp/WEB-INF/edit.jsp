<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<title>Edit Car</title>
</head>
<body>
<h1>Edit</h1>

<form:form action="/cars/${car.id }/edit" method="post" modelAttribute="car">
<input type="hidden" name="_method" value="put"/>
			<div>
			<form:errors style="color:red" path="*" />
			</div>
			<p>
				<form:label path="model">model:</form:label>
				<form:input path="model" />
				
			</p>
			
			<p>
				<form:label path="color">Color:</form:label>
				<form:input type="color" path="color" />
				
			</p>
			
			<button>Submit</button>
		</form:form>
		<form action="/cars/${car.id }/delete" method ="POST">
		<input type="hidden" name="_method" value="delete"/>
		<button>Delete</button>

</body>
</html>