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

<title>Edit TV Show</title>
</head>
<body>
<h1>Edit</h1>


			
			
		<form:form action="/shows/${show.id }/edit" method="post" modelAttribute="show">
		<input type="hidden" name="_method" value="put"/>
		<div>
		<form:errors style="color:red" path="*" />
		</div>
			<p>
				<form:label path="title">Title</form:label>
				<form:input path="title" />
				
			</p>
			
			<p>
				<form:label path="network">Network</form:label>
				<form:input path="network" />
				
			</p>
			<p>
				<form:label path="description">Description</form:label>
				<form:textarea path="description" rows="3" cols="20" />
			</p>
			<button>Submit</button>
			<button><a href="/shows">Cancel</a></button>
		</form:form>
		
		<form action="/shows/${show.id }/delete" method ="POST">
		<input type="hidden" name="_method" value="delete"/>
		<button>Delete</button>
	

</body>
</html>