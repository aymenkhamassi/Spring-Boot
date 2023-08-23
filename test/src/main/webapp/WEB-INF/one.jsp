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

<title>Edit My Task</title>
</head>
<body>
<div class="container">
<h1 style="color:grey">The Wire</h1></br>
<h3>Posted By :${thisShow.user.userName }</h3></br>
<h3>Network : ${thisShow.network }</h3></br>
<h3>Description : ${thisShow.description }</h3></br>
<c:if test="${thisShow.user.id eq user_id }"><button class="btn btn-success"><a href="/shows/${thisShow.id  }/edit" style="text-decoration:none;color:white">Edit</a></button></c:if>
</br>
<a href="/shows" style="text-decoration:none">Back to Dashboard</a>
</div>

</body>
</html>