<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Management</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<center>
		<div class="container">
			<div class="col-md-offset-3 col-md-5">
				<h1 class="text-center">Employee Login</h1>
				<hr />

				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="panel-title">Login</div>
					</div>
					<div class="panel-body">
						<form:form action="employee/login" method="post"
							modelAttribute="Login">
							<table>
								<tr>
									<td>Username</td>
									<td><input type="text" name="username"></td>
								</tr>
								<tr>
									<td>Password</td>
									<td><input type="password" name="password"></td>
								</tr>
								<tr>
									<td><button type="submit">Login</button></td>
								</tr>
							</table>
						</form:form>
					</div>
				</div>
			</div>

		</div>
	</center>
</body>

</html>