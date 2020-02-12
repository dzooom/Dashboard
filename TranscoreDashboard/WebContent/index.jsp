<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/login" method="post">
	
	<div>
		User Name : <input type="text" name="username">
	</div>
	<div>
		Password : <input type="text" name="password">
	</div>
	<div>
		<input type="submit" value="Login">
	</div>
	</form>
</body>
</html>