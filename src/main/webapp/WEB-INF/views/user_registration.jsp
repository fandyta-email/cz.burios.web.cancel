<%@ page language="java" session="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<html>
<head>
	<title>
		<fmt:bundle basename="messages">
			<fmt:message key="page.title" />
		</fmt:bundle>
	</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/style.css"/>" />
</head>
<body>
	<div id="login-box">
		<h2>Registration</h2>
		<form name='loginForm' action="<c:url value='/registration' />" method='POST'>
			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' name='username' value=''></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' name='password' /></td>
				</tr>
				<tr>
					<td colspan='2'>
						<input name="submit" type="submit" value="Submit" />
					</td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>
