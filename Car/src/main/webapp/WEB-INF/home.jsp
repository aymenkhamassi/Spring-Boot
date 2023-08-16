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
<h1>Cars</h1>
<a href="/logout">Logout</a>

<c:forEach items="${allCars }" var="oneCar">
<p><a href="/cars/${oneCar.id }">${oneCar.model }</a>
 is driven by ${oneCar.driver.userName } 
 <c:if test="${oneCar.driver.id eq user_id }"><a href="/cars/${oneCar.id }/edit">Edit</a></p> </c:if>
 
</c:forEach>



<form:form action="/cars" method="post" modelAttribute="car">
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

</body>
</html>