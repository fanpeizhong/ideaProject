<%--
  Created by IntelliJ IDEA.
  User: 范培忠
  Date: 2017/3/19
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Role Details</title>
    <style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="global">
    <h4>Role Details.</h4>
    <pre>
            <h5>Details:</h5>
            Role ID:${roleBean.id}
            Role Name:${roleBean.roleName}
            Create Date:${roleBean.createDate}
            Note:${roleBean.note}
    </pre>
</div>
</body>
</html>
