<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Counter</title>
</head>
<body>
    <h1>Counter: ${counter}</h1>
    <form action="/counter/increment" method="post">
        <button type="submit">Increment</button>
    </form>
    <form action="/counter/incrementByTwo" method="post">
        <button type="submit">Increment by 2</button>
    </form>
    <form action="/counter/reset" method="post">
        <button type="submit">Reset</button>
    </form>
</body>
</html>