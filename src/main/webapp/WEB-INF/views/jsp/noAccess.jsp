<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:simpleErrorTemplate>
	<jsp:body>
		<div class="error-topmargin">
			<div class="row">
				<div class="col-xs-12 col-sm-8 col-sm-offset-2">
					<div class="content-box warning-padding">
						<h3>${noAccessTitle}</h3>
						<p>${noAccessMsg}, please return to <a href="${pageContext.request.contextPath}/index">Home</a>.</p>
						<p>Login and access protected pages <a href="${pageContext.request.contextPath}/login">Login</a>.</p>
					</div>
				</div>
			</div>
		</div>
	</jsp:body>
</t:simpleErrorTemplate>