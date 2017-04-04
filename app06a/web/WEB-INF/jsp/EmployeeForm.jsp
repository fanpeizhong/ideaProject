<%--
  Created by IntelliJ IDEA.
  User: 范培忠
  Date: 2017/1/30
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee Form</title>
</head>
<body>
<div id="global">
    <form:form commandName="employee" action="employee_save" method="post">
        <fieldset>
            <legend>Add an employee</legend>
            <p>
                <label for="firstName">First Name:</label>
                <form:input path="firstName" tabindex="1"/>
            </p>
            <p>
                <label for="lastName">Last Name:</label>
                <form:input path="lastName" tabindex="2"/>
            </p>
            <p>
                <form:errors path="birthDate"/>
            </p>
            <p>
                <label for="birthDate">Birth Day:</label>
                <form:input path="birthDate" tabindex="3"/>
            </p>
            <input type="reset"/>
            <input type="submit"/>
        </fieldset>
    </form:form>
</div>
</body>
</html>