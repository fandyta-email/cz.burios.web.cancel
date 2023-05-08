<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>
		<fmt:bundle basename="messages">
			<fmt:message key="page.title" />
		</fmt:bundle>
	</title>
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<div class="w3-bar w3-border  w3-black">
		<a href="#" class="w3-bar-item w3-button w3-hover-black">
			<fmt:bundle basename="messages">
				<fmt:message key="page.home.heading" />
			</fmt:bundle>
		</a>
		<a href="${pageContext.request.contextPath}/admin" 
			class="w3-bar-item w3-button w3-right w3-hover-red">Login</a>
		<a href="${pageContext.request.contextPath}/auth/user_registration" 
			class="w3-bar-item w3-button w3-right w3-hover-red">Registrace</a>		
	</div>
	<div align="center">
		<h1>
			<fmt:bundle basename="messages">
				<fmt:message key="page.home.heading" />
			</fmt:bundle>
		</h1>
		<a href="${pageContext.request.contextPath}/admin">
			<fmt:bundle basename="messages">
				<fmt:message key="page.goto.admin" />
			</fmt:bundle>
		</a>
	</div>
</body>
</html>
