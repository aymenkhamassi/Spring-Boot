<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>

    <h3>Send an Omikuji !</h3>
    <form action='/processForm' method='POST'></br>
    <label>Pick any number from 5 to 25</label></br>
    <input type = "number" name = 'number'></br>
	<label>Enter the name of any city</label></br>
    <input type="text" name='city'></br>
	<label>Enter the name of any real person</label></br>
    <input type='text' name='person'></br>
    <label>Enter professional endeavor or hobby</label></br>
    <input type='text' name='hobby'></br>
    <label>Enter any type of living thing</label></br>
    <input type='text' name='living'></br>
    <label>Say something nice to someone</label></br>
    <input type='text' name='nice'></br>
    <input type='submit' value='Send'>
    </form>



</body>
</html>