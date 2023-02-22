<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Owner</title>
</head>
<body>
	<form action="editOwnerDetailsServlet" method="post">
	<input type="hidden" name="id" value="${ownerToEdit.id}">
	Owner Name: <input type="text" name="ownerName" value="${ownerToEdit.owner.ownerName}"><br>
	DL Number: <input type="text" name="dlNumber" value="${ownerToEdit.dlNumber}"><br>
	Available Cars:<br>
	<select name="allCarsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allCars}" var="currentcar">
	<option value="${currentcar.id}">${currentcar.make}/${currentcar.model}/${currentcar.year}</option>
	</c:forEach>
	</select><br>
	<input type="submit" value="Edit Owner and Add Cars">
	</form>
	<a href="index.html">Add new cars instead</a>
</body>
</html>