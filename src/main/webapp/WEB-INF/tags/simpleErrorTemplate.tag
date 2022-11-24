<%@ tag description="Overall Page template" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="cs">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>${siteName} - ${viewName}</title>
		
		<link href="${pageContext.request.contextPath}/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/assets/custom/css/index.css" rel="stylesheet">
	</head>
	<body>
		<div class="row">
			<div class="col-xs-12">
				<jsp:doBody/>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<p class="vertical-placeholder"></p>
			</div>
		</div>
		<%@ include file="jspf/footer.jspf" %>
		<script src="${pageContext.request.contextPath}/assets/jquery/js/jquery-2.2.4.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/bootstrap/js/bootstrap.min.js"></script>
	</body>
</html>