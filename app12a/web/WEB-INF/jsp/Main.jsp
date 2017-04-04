<%--
  Created by IntelliJ IDEA.
  User: 范培忠
  Date: 2017/2/28
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Download Page</title>
    <style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
    <c:if test="${loggedIn}">
        欢迎你，${login.getUserName()}.
    </c:if>
    <div id="global">
        <h4>Please click the link below.</h4>
        <p>
            <a href="/resource_download">Download</a>
        </p>
    </div>
</body>
</html>
