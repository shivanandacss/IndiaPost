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
		<input type="hidden" name="indiaPost" value="register">

		<h1 style="color: red" align="center">Registration page</h1>
		<table border="1" align="center">
			<tr>
				<td>FirstName:</td>
				<td><input type="text" name="firstName" required="required"></td>
			</tr>

			<tr>
				<td>LastName:</td>
				<td><input type="text" name="lastName" required="required"></td>
			</tr>

			<tr>
				<td>SEX:</td>
				<td><input type="radio" name="gender" value="male">Male
					<input type="radio" name="gender" value="female">Female</td>
			</tr>

			<tr>
				<td>PhoneNumber:</td>
				<td><input type="text" name="number"></td>
			</tr>

			<tr>
				<td>Address Type:</td>
				<td><input type="radio" name="addressType" value="Home"
					required="required">Home <input type="radio"
					name="addressType" value="office" required="required">Office</td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" required="required"></td>
			</tr>

			<tr>
				<td>Username:</td>
				<td><input type="text" name="username" required="required"></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" required="required"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="submit" /> <input type="reset"></td>

			</tr>


		</table>
	</form>
	</center>

</body>
</html>