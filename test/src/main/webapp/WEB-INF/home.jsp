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
<div class="container">
<div style="display:flex;justify-content: space-around">
<h1 style="color:blue">Welcome ,${user.userName }</h1>


<h5 style="margin-top:10px"><a href="/logout" style="text-decoration:none">Logout</a></h5>
</div>
<h3>TV Shows</h3>

<table class="table table-striped">
<thead>
<tr>
<th>Show</th>
<th>Network</th>
</tr>
</thead>
<tbody>
<c:forEach var="show" items="${showNames}">
<tr>
<td><a href="/shows/${show.id }" style="text-decoration:none">${show.title }</a></td>
<td>${show.network }</td>
</tr>
</c:forEach>
</tbody>
</table>

<button class="btn btn-primary"><a href="/shows/new"  style="text-decoration:none;color:white">Add a Show</a></button>
</div>
</body>
</html>