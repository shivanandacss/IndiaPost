<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="silver">
	<form action="UserLoginController1" method="post">
		<table align="center" border="1">
			<caption>User Login Page</caption>

			<tr>
				<td><label>UserName</label></td>
				<td><input type="text" required autofocus name="UserName"></td>
			</tr>
			<tr>
				<td><label>Password</label></td>
				<td><input type="password" required autofocus name="Password"></td>
			</tr>

			<tr>
				<td></td>
				<td><button type="submit">Submit</button><button type="reset">Reset</button></td>
			</tr>
			<tr>
				<td><a href="register.jsp">New User?Register here</a></td>
			</tr>
		</table>
		<input type="hidden" name="indiaPost" value="login" />
	</form>
</body>
</html>