<%--
  Created by IntelliJ IDEA.
  User: 范培忠
  Date: 2017/1/27
  Time: 8:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Book Form 1</title>
</head>
<body>
<div id="global">
    <form:form commandName="book" action="/book_update" method="post">
        <fieldset>
            <legend>Add a book</legend>
            <p>
                <label for="category">Category:</label>
                <form:select id="category" path="category.id" items="${categories}" itemLabel="name" itemValue="id"/>
            </p>
            <p>
                <label for="title">Title：</label>
                <form:input path="title" id="title"/>
            </p>
            <p>
                <label for="author">Author：</label>
                <form:input path="author" id="author"/>
            </p>
            <p>
                <label for="isbn">ISBN：</label>
                <form:input path="isbn" id="isbh"/>
            </p>
            <p id="buttons">
                <input id="reset" type="reset"/>
                <input type="submit"/>
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>
