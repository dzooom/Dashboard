<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/validator.js"></script>
</head>
<body>

<h2>add category</h2>

<form action="${pageContext.request.contextPath}/plate-category" method="post">


<div class="container">

	<div>
		Plate Category Desc	<input id="txtCategoryDesc" type="text" name="categorydesc" value="${category.plateCategoryDesc}">
	</div>
	
	<div>
		Display Order	<input type="text" name="displayorder" value="${category.displayOrder}">
	</div>
	
	<div>
		Plate Category Desc Arabic	<input type="text" name="categorydescar" value="${category.plateCategArbDesc}">
	</div>
	
	<div>
		<input type="submit" class="btn btn-primary" onClick="return validateForm();">
	</div>

</div>

</form>

</body>
</html>