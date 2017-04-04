<%--
  Created by IntelliJ IDEA.
  User: 范培忠
  Date: 2017/2/28
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<div id="global">
    <form:form commandName="login" action="/login" method="post">
        <fieldset>
            <legend>Login</legend>
            <p>
                <label for="userName">User Name:</label>
                <form:input path="userName" id="userName" cssErrorClass="error"/>
            </p>
            <p>
                <label for="password">Password:</label>
                <form:password path="password" id="password" cssErrorClass="error"/>
            </p>
            <input type="reset"/>
            <input type="submit"/>
        </fieldset>
    </form:form>
</div>
</body>
</html>
