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

<title>Home Page</title>
</head>
<body>
<h1>Welcome ,${user.userName }</h1>
<h4>Books from everyone's shelves</h4>
<p><a href="/books/new">Add to My shelf</a></p>

<table class="table">
<thead>
<tr>
<th>ID</th>
<th>Title</th>
<th>Author Name</th>
<th>Posted By</th>
</tr>
</thead>
<tbody>
<c:forEach var="book" items="${bookNames}">
<tr>
<td>${book.id }</td>
<td>${book.title }</td>
<td>${book.author }</td>
<td>${book.user.userName }</td>
</tr>
</c:forEach>
<p><a href="/logout">Logout</a>
</tbody>
</table>
</body>
</html>