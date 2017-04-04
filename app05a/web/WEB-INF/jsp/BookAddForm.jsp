<%--
  Created by IntelliJ IDEA.
  User: 范培忠
  Date: 2017/1/27
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book Form - F</title>
</head>
<body>
<div id="global">
    <form:form commandName="book" action="/book_save" method="post">
        <fieldset>
            <legend>Add a book</legend>
            <p>
                <label for="category">Category:</label>
                <form:radiobuttons path="category.id" id="category"
                             items="${categories}" itemValue="id" itemLabel="name"/>
            </p>
            <p>
                <label for="title">Title:</label>
                <form:input path="title" id="title"/>
            </p>
            <p>
                <label for="author">Author:</label>
                <form:input path="author" id="author"/>
            </p>
            <p>
                <label for="isbn">ISBN:</label>
                <form:input path="isbn" id="isbn"/>
            </p>
            <input type="reset"/>
            <input type="submit"/>
        </fieldset>
    </form:form>
</div>
</body>
</html>
