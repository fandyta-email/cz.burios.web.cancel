<%@ page language="java" session="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<link rel="stylesheet" href="https://maxst.icons8.com/vue-static/landings/line-awesome/font-awesome-line-awesome/css/all.min.css">	
	<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/style.css"/>" />
</head>
<body>
	<div class="w3-bar w3-border  w3-black">
		<a href="${pageContext.request.contextPath}/login" 
			class="w3-bar-item w3-button w3-hover-red">
				<i class="las la-arrow-left"></i>&nbsp;
			</a>		
	</div>
	<div>error:(${error})</div>
	<div class="w3-panel w3-padding-16">
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<form name='loginForm' action="<c:url value='user_registration' />" method='POST'>
			<c:if test="${not empty param.recordId}">
				<input id="recordId" name="recordId" value="${ param.recordId }">
			</c:if>
			<table>
				<tr>
					<td>User:</td>
					<td><input type='text' id='userName' name='userName' value='' class="w3-input w3-border"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type='password' id='userPassword'  name='userPassword' value='' class="w3-input w3-border"/></td>
				</tr>
				<tr>
					<td colspan='2'>
						<input id="submit" type="submit" value="Zapsat" class="w3-btn w3-black"/>
					</td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
</body>
</html>