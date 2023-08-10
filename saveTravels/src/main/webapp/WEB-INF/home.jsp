<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Save Travels</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
   <h1 style="color:blue">Save Travels 🛩️</h1>
   <hr />
   <table class="table table-striped">
   <thead>
   <tr>
   <th>Expense</th>
   <th>Vendor</th>
   <th>Amount</th>
   </tr>
   </thead>
   <tbody>
   <c:forEach items="${travelsList }" var="oneTravel" >
   <tr>
   <td>${oneTravel.expname}</td>
   <td>${oneTravel.vendor}</td>
   <td>${oneTravel.amount}</td>
   <td><a href="/expenses/${oneTravel.id }/edit">Edit</a></td>
   <td><form action="/expenses/${oneTravel.id }" method="post">
   	<input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete"></form></td>
   </tr>
   </c:forEach>
   </tbody>
   </table>
   </div>
   
   <div class="container" >
   <h1 style="color:blue">Add an Expense</h1>
   <form:form action="/expenses/create" method="post" modelAttribute="travel" >
   <form:errors class="text-danger" path="*"/>
    <div class="form-group" >
        <form:label path="expname" >Expense Name</form:label>
        <form:input path="expname" class="form-control"/>
    </div>
    <div class="form-group">
        <form:label path="vendor">Vendor</form:label>
        <form:input path="vendor" class="form-control"/>
    </div>

    <div class="form-group">
        <form:label path="amount">Amount</form:label>
        <form:input type="number" path="amount" class="form-control"/>
    </div>  
     <div class="form-group">
        <form:label path="description">Description</form:label>
        <form:input path="description" class="form-control"/>
    </div>   
    <button class="btn btn-success">Submit</button>
</form:form>    
   
   
   
   </div>
   
   
   

   
</body>
</html>