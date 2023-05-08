<%@ page language="java" session="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>
		<%-- 
		<fmt:bundle basename="messages">
			<fmt:message key="page.title" />
		</fmt:bundle>
		--%>
		Buriosca.cz - Devel
	</title>
	<%-- 
	--%>
	<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/style.css"/>" />
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
</head>
<body>
	<div class="w3-bar w3-border  w3-black">
		<a href="${pageContext.request.contextPath}/" class="w3-bar-item w3-button w3-hover-black">
			<fmt:bundle basename="messages">
				<fmt:message key="page.home.heading" />
			</fmt:bundle>
		</a>
		<a href="${pageContext.request.contextPath}/auth/user_registration" 
			class="w3-bar-item w3-button w3-right w3-hover-red">Registrace</a>		
	</div>
	<div id="login-box">
		<h2>
			<fmt:bundle basename="messages">
				<fmt:message key="page.login.heading" />
			</fmt:bundle>
		</h2>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		<form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>
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
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>