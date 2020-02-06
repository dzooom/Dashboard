<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.transcore.entity.PlateCategory" %>
<%@ page import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Description EN</th>
			<th>Display Order</th>
			<th>Description AR</th>
		</tr>
	</thead>
	<tbody>
		
	<c:forEach var="category" items="${data}">	
	
	<tr>
		<td>${category.plateCategoryId}</td>
		<td>${category.plateCategoryDesc}</td>
		<td>${category.displayOrder}</td>
		<td>${category.plateCategArbDesc}</td>
	</tr>
	
	</c:forEach>
	
	</tbody>
</table>





</body>
</html>