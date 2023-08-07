<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Fruit Store</h1>

<table>
<tr>
<th>Name</th>
<th>Price</th>
</tr>

<c:forEach items ="${fruits}" var = "oneItem">
<tr>
<td>
<c:out value="${oneItem.name }"/>
</td>
<td>
<c:out value="${oneItem.price }"/>
</td>
</tr>
</c:forEach>
</table>


</body>
</html>