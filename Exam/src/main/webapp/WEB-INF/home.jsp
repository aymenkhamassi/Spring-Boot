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

<title>Project Manager Dashboard</title>
</head>
<body>
<h1>Welcome ,${user.userName }</h1>

<p><a href="/logout">Logout</a>

<h3>TV Shows</h3>

<table class="table">
<thead>
<tr>
<th>Show</th>
<th>Network</th>
</tr>
</thead>
<tbody>
<c:forEach var="show" items="${showNames}">
<tr>
<td><a href="/shows/${show.id }">${show.title }</a></td>
<td>${show.network }</td>
</tr>
</c:forEach>
</tbody>
</table>

<button><a href="/shows/new">Add a Show</a></button>

</body>
</html>