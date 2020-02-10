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
	<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>



<div class="container">
<div style="padding-top:20px">
<a href="${pageContext.request.contextPath}/views/add-category.jsp" class="btn btn-primary">Add Category</a>
<table border="2" class="table">
	<thead>
		<tr>
			<th>ID</th>
			<th>Description EN</th>
			<th>Display Order</th>
			<th>Description AR</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		
	<c:forEach var="category" items="${data}">	
	
	<tr>
		<td>${category.plateCategoryId}</td>
		<td>${category.plateCategoryDesc}</td>
		<td>${category.displayOrder}</td>
		<td>${category.plateCategArbDesc}</td>
		<td><a href="plate-category?action=edit&categoryid=${category.plateCategoryId}"> Edit </a> | <a href=""> Delete </a></td>
	</tr>
	
	</c:forEach>
	
	</tbody>
</table>
</div>

</div>
</body>
</html>