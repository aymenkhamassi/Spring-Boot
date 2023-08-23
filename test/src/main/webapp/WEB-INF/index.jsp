<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Manager</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->

</head>
<style>
       label{
       color:white;
       }
</style>
<body>
<h1 style="color:blue;text-align:center;margin-top:30px">TV Shows Database</h1>
    <div class="container" >
    
        <div class="row justify-content-center mt-5" >
            <!-- REGISTER A NEW USER -->
            <div class="col-md-6" >
                <div class="login-reg-main border rounded p-4" style="background:rgba(10, 30, 120, 0.5)">
                    <h3 class="mb-4" Style="color:white;text-align:center">Register</h3>
                    <form:form action="/register" method="post" modelAttribute="newUser">
                        <div class="form-group">
                            <label for="userName">User Name:</label>
                            <form:input path="userName" class="form-control" id="userName" />
                            <form:errors path="userName" class="text-danger" />
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <form:input path="email" class="form-control" id="email" />
                            <form:errors path="email" class="text-danger" />
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <form:password path="password" class="form-control" id="password" />
                            <form:errors path="password" class="text-danger" />
                        </div>
                        <div class="form-group">
                            <label for="confirm">Confirm Password:</label>
                            <form:password path="confirm" class="form-control" id="confirm" />
                            <form:errors path="confirm" class="text-danger" />
                        </div>
                        </br>
                        <input type="submit" value="Register" class="btn btn-primary" />
                    </form:form>
                </div>
            </div>
            
            <!-- LOGIN -->
            <div class="col-md-6">
                <div class="login-reg-main border rounded p-4" style="background:rgba(10, 30, 120, 0.5)">
                    <h3 class="mb-4" style="color:white;text-align:center">Login</h3>
                    <form:form action="/login" method="post" modelAttribute="newLogin">
                        <div class="form-group">
                            <label for="loginEmail">Email:</label>
                            <form:input path="email" class="form-control" id="loginEmail" />
                            <form:errors path="email" class="text-danger" />
                        </div>
                        <div class="form-group">
                            <label for="loginPassword">Password:</label>
                            <form:password path="password" class="form-control" id="loginPassword" />
                            <form:errors path="password" class="text-danger" />
                        </div>
                        </br>
                        <input type="submit" value="Login" class="btn btn-success" />
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
