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

<title>Create a Task</title>
</head>
<body>
<div class="container">
<h1>Create a New TV Show</h1>


<div class="row justify-content-center mt-5" >
<div class="col-md-6" >
<div class="login-reg-main border rounded p-4">
		<form:form action="/shows/new" method="post" modelAttribute="showName">
			<form:hidden path="user" value="${user.id }" />
			<div class="form-group">
				<form:label path="title" >Title</form:label></br>
				<form:input path="title" /></br>
				<form:errors path="title" class="text-danger"/>
			</div></br>
			
			<div class="form-group">
				<form:label path="network">Network</form:label></br>
				<form:input path="network" /></br>
				<form:errors path="network" class="text-danger"/>
			</div></br>
			<div class="form-group">
				<form:label path="description">Description</form:label></br>
				<form:textarea path="description" rows="3" cols="20" /></br>
				<form:errors path="description" class="text-danger"/>
			</div></br>
			<button class="btn btn-success">Submit</button>
			<button class="btn btn-primary"><a href="/shows" style="text-decoration:none;color:white">Cancel</a></button>
		</form:form>
	</div>
	</div>
	</div>
	</div>


</body>
</html>