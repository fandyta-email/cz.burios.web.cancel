<%@ page language="java" session="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
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
	<div align="center">
		<h1>${title}</h1>
		<h2>${message}</h2>
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				<fmt:bundle basename="messages">
					<fmt:message key="welcome.msg" />
				</fmt:bundle>
				: ${pageContext.request.userPrincipal.name} | <a
					href="<c:url value='logout'/>"><fmt:bundle basename="messages">
						<fmt:message key="logout.text" />
					</fmt:bundle></a>
			</h2>
		</c:if>
	</div>
</body>
</html>
