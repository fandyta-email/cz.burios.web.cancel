<%@page contentType="text/html" trimDirectiveWhitespaces="true" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<t:indexTemplate>
    <jsp:body>
       <div class="row">
          <div class="col-xs-12">
             <div class="content-box">
                <h1>Welcome</h1>
                <p>This page can be only accessed by SITE STAFF.</p>
             </div>
          </div>
       </div>
    </jsp:body>
</t:indexTemplate>