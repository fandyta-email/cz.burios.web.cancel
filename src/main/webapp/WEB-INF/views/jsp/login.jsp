<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:loginTemplate>
	<jsp:attribute name="loginCss">
	</jsp:attribute>
	<jsp:attribute name="loginJs">
		<script src="${pageContext.request.contextPath}/assets/custom/js/login.js"></script>
	</jsp:attribute>
	<jsp:body>
		<div style="margin-top: 100px">
			<div class="row">
				<div class="col-xs-2 col-sm-3 col-md-4 col-lg-4"></div>
				<div class="col-xs-8 col-sm-6 col-md-4 col-lg-4">
					<div class="content-box">
						<h3>Please Sign In</h3>
						<form id="loginForm" class="form-horizontal" action="<c:url value='/login'/>" method="POST">
							<div class="form-group">
								<div class="col-xs-12">
									<input type="text" class="form-control" id="username" name="username" placeholder="User Name">
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-12">
									<input type="password" class="form-control" id="password" name="password" placeholder="Password">
								</div>
							</div>
							<div id="loginError" class="row" style="display: none;">
								<div class="col-xs-12">
									<div id="loginErrorMsg" class="alert alert-danger alert-padding" role="alert"></div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-2"></div>
								<div class="col-xs-5"><input type="submit" class="form-control btn btn-primary" value="Log In"></div>
								<div class="col-xs-5"><input type="reset" class="form-control btn btn-default" value="Clear"></div>
							</div>
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
					</div>
				</div>
				<div class="col-xs-2 col-sm-3 col-md-4 col-lg-4"></div>
			</div>
		</div>
	</jsp:body>
</t:loginTemplate>