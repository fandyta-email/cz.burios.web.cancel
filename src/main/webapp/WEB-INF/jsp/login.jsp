<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
%>
<html>
<head>
	<title>Buriosca.cz - Cancel</title>
	<link href="<c:url value="/libs/api/desktop.core.css"/>" rel="stylesheet" type="text/css">
	<style type="text/css">
		body {
			height: 100vh;
			width: 100vw;
			box-sizing: border-box;
			overflow: hidden;
			padding: 0;
			margin: 0;
    	}
		.parent {
			height: 100%;
			width: 25vw;
			border-left: 1px solid #ddd;
			display: flex;
			align-items: center;
			justify-content: center;
			position: absolute;
			right: 0;
		}
		.child {
			padding: 2em 1em;
			width: 80%;
		}
		.row {
			box-sizing: border-box;
			display: flex;
			padding: 2px 8px;
		}
		.row label {
			flex-basis: 50%;
			flex-wrap: nowrap;
		}
		.row input[type="text"], .row input[type="password"] {
			flex-basis: 50%;
			border: 1px solid #ddd;
			height: 32px; 
			height: 24px;
		}
		.msg-error {
			flex-basis: 100%;
			align-items: center;
			justify-content: center;
			padding-bottom: 1em;
		}
		.msg-error span .err {
			color: red;
		}
		.msg-error span .info {
			color: green;
		}
		
		.button {
			color: #fff;
			background-color: #008ae6;
			border: 1px solid #008ae6;
			padding: 8px 16px;
		}
	</style>
</head>
<body>
	<div id="headerPart" style="background-color: orange; height: 3em; position: fixed; top: 0; width: 100%; display: flex; padding: 4px; box-sizing: border-box;">
		<h3 style="align-items: center;">Buriosca.cz - Cancel</h3>
	</div>
	<div id="contentPart" style="height: 100vh; margin-top: 3em;">
		<form method="post" action="<c:url value='/login' />">
			<div class="parent">
				<div class="child">
					<div class="row" style="align-items: center; justify-content: center;">
						<h2>Login</h2>
					</div>
					<div class="row msg-error" >
						<c:if test="${ errcode eq 'ERR_403' }">
							<span class="text-error">Chybně zadané jméno nebo heslo</span>
						</c:if>
						<c:if test="${ errcode eq 'ERR_LOGOUT' }">
							<span class="text-info">Byl jste odhlášen</span>
						</c:if>
					</div>
					<div class="row">
						<label for="username" style="text-align: right; padding: 0 8px;">User</label>
						<input type="text" id="username" name="username" value="">
					</div>
					<div class="row"> 
						<label for="password" style="text-align: right; padding: 0 8px;">Password</label>
						<input type="password" id="password" name="password" value="">
					</div>
					<div class="row" style="justify-content: center; margin: 2em 0;"> 
						<button type="submit" class="button">Login</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>