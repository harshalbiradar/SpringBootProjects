<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<div>
		<form action="/login" method="post" style="max-width: 400px;margin: 0 auto;">
		<h1>Login to my app</h1>
		<div>
			Name: <input type="text" name="username" required="required">
		</div>
		<div>
			Password: <input type="password" name="password" required="required">
		</div>
			<input type="submit" value="SignIn">
		</form>
	</div>
</body>
</html>