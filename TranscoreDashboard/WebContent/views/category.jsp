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
	<script type="text/javascript" src="js/application.js"></script>
</head>
<body>

<div class="container page-container">

 <jsp:include page="components/header.jsp"></jsp:include>

<div class="content">

<div>
<div style="padding-top:20px">

<div id="search">
	<input type="text" name="categorydesc" id="idcategorydesc">
	<input type="text" name="displayorder" id="iddisplayorder">
	<a href="#" onclick="searchCategory();">Search</a>
</div>


<a href="${pageContext.request.contextPath}/views/add-category.jsp" class="btn btn-primary">Add Category</a>
<table  class="table">
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
		<td><a href="plate-category?action=edit&categoryid=${category.plateCategoryId}"> Edit </a> | 
		<a href="plate-category?action=delete&categoryid=${category.plateCategoryId} "> Delete </a></td>
	</tr>
	
	</c:forEach>
	
	</tbody>
</table>
</div>
</div>

</div>

<jsp:include page="components/footer.jsp"></jsp:include>

</div>
</body>
</html>