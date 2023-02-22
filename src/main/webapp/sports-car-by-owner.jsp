<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Owners</title>
</head>
<body>
	<form method = "post" action = "ownerNavigationServlet">
	<table>
	<c:forEach items="${requestScope.allOwners}" var="currentowner">
	<tr>
		<td><input type="radio" name ="id" value="${currentowner.id}"></td>
		<td><h2>${currentowner.owner.ownerName}'s Garage</h2></td>
	</tr>
	<tr><td colspan="3">Owner: ${currentowner.owner.ownerName}</td></tr>
	<tr><td colspan="3">DL Number: ${currentowner.dlNumber}</td></tr>
	<c:forEach items="${currentowner.listOfCars}" var="carVal">
	<tr>
		<td></td>
		<td colspan="3">
		${carVal.make}/${carVal.model}/${carVal.year}
		</td>
	</tr>
	</c:forEach>
	</c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToOwner">
	<input type="submit" value="delete" name="doThisToOwner">
	<input type="submit" value="add" name="doThisToOwner">
	</form>
	<a href="addOwnerServlet">Create a new owner</a><br>
	<a href="index.html">Insert a new car</a>
</body>
</html>