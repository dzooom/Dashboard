<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
</head>
<body>

<h2>add category</h2>

<form action="/plate-category" method="post">


<div class="container">

	<div>
		Plate Category Desc	<input type="text" name="categorydesc">
	</div>
	
	<div>
		Display Order	<input type="text" name="displayorder">
	</div>
	
	<div>
		Plate Category Desc Arabic	<input type="text" name="categorydescar">
	</div>
	
	<div>
		<input type="submit" class="btn btn-primary">
	</div>

</div>

</form>

</body>
</html>