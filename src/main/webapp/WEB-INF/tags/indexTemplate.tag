<%@ tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ attribute name="header" fragment="true"%>
<%@ attribute name="footer" fragment="true"%>
<%@ attribute name="additionalCss" fragment="true"%>
<%@ attribute name="additionalJs" fragment="true"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="cs">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Test Spring MVC and Security - ${userRole} &amp;
			${pageName}</title>
		
		<link href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/assets/custom/css/index.css" rel="stylesheet">
		<jsp:invoke fragment="additionalCss" />
	</head>
	<body>
		<div class="row-fluid" style="margin-top: 0px;">
			<div class="col-xs-12">
				<ul class="nav nav-pills navbar-right">
					<li><a href="${pageContext.request.contextPath}/">Home</a></li>
					<sec:authorize access="hasRole('ROLE_SITE_ADMIN')">
						<li><a href="${pageContext.request.contextPath}/secure/testPage1">Test Page #1</a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_SITE_STAFF')">
						<li><a href="${pageContext.request.contextPath}/secure/testPage2">Test Page #2</a></li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_SITE_USER')">
						<li><a href="${pageContext.request.contextPath}/secure/testPage3">Test Page #3</a></li>
					</sec:authorize>
					<sec:authorize access="!hasRole('ROLE_ANONYMOUS')">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Account<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<sec:authorize access="!hasRole('ROLE_ANONYMOUS')">
									<li><a href="${pageContext.request.contextPath}/logout">Log Out</a></li>
								</sec:authorize>
							</ul>
						</li>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
						<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
					</sec:authorize>
				</ul>
			</div>
		</div>
		<div class="row-fluid">
			<div class="col-xs-12">
				<ol class="breadcrumb">
					<li>
						<h4>
							<img alt="Brand" src="${pageContext.request.contextPath}/assets/images/testicon.png" width="24" height="24">&nbsp;Sample Spring App
						</h4>
					</li>
				</ol>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<jsp:invoke fragment="header" />
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<jsp:doBody />
				</div>
			</div>
		</div>
		<p class="vertical-placeholder"></p>
		<%@ include file="jspf/footer.jspf"%>
		<script src="${pageContext.request.contextPath}/assets/jquery/js/jquery-2.2.4.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.min.js"></script>
		<jsp:invoke fragment="additionalJs" />
	</body>
</html>