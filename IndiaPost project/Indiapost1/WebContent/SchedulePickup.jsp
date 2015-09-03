<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UserLoginController1" method="post">
		<input type="hidden" name="indiaPost" value="schedule">



	<h1 style="color: red" align="center">Registration page </h1>	
		<table border="1" align="center">

	
			<tr>
				<td>Date to pickup:</td>

				<!-- <input type="text" name="scheduleDate" required="required"> -->

				<td><select name="date">
						<%
							for (int i = 1; i <= 31; i++) {
						%>
						<option value="<%=i%>">
							<%=i%>
						</option>
						<%
							}
						%>
				</select> <select name="month">
						<%
							for (int i = 1; i <= 12; i++) {
						%>
						<option value="<%=i%>">
							<%=i%>
						</option>
						<%
							}
						%>
				</select> <select name="year">
						<%
							for (int i = 2015; i < 2026; i++) {
						%>
						<option value="<%=i%>">
							<%=i%>
						</option>
						<%
							}
						%>
				</select></td>

			</tr>

			<tr>
				<td>Time to pickup:</td>
				<!-- 				<td><input type="text" name="scheduleTime" required="required"></td>
 -->
				<td><select name="hour">
						<%
							for (int i = 0; i < 24; i++) {
						%>
						<option value="<%=i%>">
							<%=i%>
						</option>
						<%
							}
						%>
				</select> <select name="min">
						<%
							for (int i = 0; i < 60; i++) {
						%>
						<option value="<%=i%>">
							<%=i%>
						</option>
						<%
							}
						%>
				</select></td>
			</tr>

			<tr>
				<td>Address</td>
				<td><input type="text" name="Address" /></td>
			</tr>

			<tr>
				<td>Approx. Weight</td>
				<td><input type="text" name="weight" required="required">
					<select name="unit">
						<option value="gm">gm</option>
						<option value="kg">kg</option>
				</select></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="submit" /> <input type="reset"></td>

			</tr>

		</table>


	</form>


</body>
</html>