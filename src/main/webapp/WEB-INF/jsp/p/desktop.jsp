<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
System.out.println("/desktop.jsp");
%>
<html>
<head>
	<title>Buriosca.cz - Cancel</title>
	<link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
</head>
<body style="box-sizing: border-box;">
	<div style="padding: 32px; text-align: center;">
		<h2>Desktop</h2>
	</div>
	<div style="text-align: center;">
		<form action="<c:url value="/logout"/>">
			<button>Logout</button>
		</form>
	</div>
</body>
</html>