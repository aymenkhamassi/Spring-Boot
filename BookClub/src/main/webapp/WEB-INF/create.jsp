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

<title>Book Share</title>
</head>
<body>


<div>
		<form:form action="/books/new" method="post" modelAttribute="bookName">
			<form:hidden path="user" value="${user.id }" />
			<p>
				<form:label path="title">Title:</form:label>
				<form:input path="title" />
				<form:errors path="title" />
			</p>
			
			<p>
				<form:label path="author">Author:</form:label>
				<form:input path="author" />
				<form:errors path="author" />
			</p>
			<p>
				<form:label path="thought">My thoughts</form:label>
				<form:textarea path="thought" rows="3" cols="20" />
				<form:errors path="thought" />
			</p>
			<button>Submit</button>
		</form:form>
	</div>


</body>
</html>