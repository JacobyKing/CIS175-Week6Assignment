<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new owner</title>
</head>
<body>
	<form action="createNewOwnerServlet" method="post">
	Owner name: <input type="text" name="ownerName"><br>
	DL number: <input type="text" name="dlNumber"><br>
	Available Cars:<br>
	<select name="allCarsToAdd" multiple size="6">
		<c:forEach items="${requestScope.allCars}" var="currentcar">
		<option value="${currentcar.id}">${currentcar.make}/${currentcar.model}/${currentcar.year}</option>
		</c:forEach>
	</select>
	<br>
	<input type="submit" value="Create Owner and Add Cars">
	</form>
	<a href="index.html">Add new cars</a>
</body>
</html>