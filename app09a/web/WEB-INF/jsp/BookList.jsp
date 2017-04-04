<%--
  Created by IntelliJ IDEA.
  User: 范培忠
  Date: 2017/2/17
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
    <div>
        <h1>Book List</h1>
        <table>
            <tr>
                <th>Category</th>
                <th>Title</th>
                <th>ISBN</th>
                <th>Author</th>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.category.name}</td>
                    <td>${book.title}</td>
                    <td>${book.isbn}</td>
                    <td>${book.author}</td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <table>
            <tr>
                <th>Category</th>
                <th>Title</th>
                <th>ISBN</th>
                <th>Author</th>
            </tr>
            <c:forEach items="${books}" var="book" varStatus="status">
                <c:if test="${status.count%2 == 0}">
            <tr style="background: #eeeeff">
                </c:if>
                <c:if test="${status.count%2 == 0}">
            <tr style="background: #dedeff">
                </c:if>
                <td>${book.category.name}</td>
                <td>${book.title}</td>
                <td>${book.isbn}</td>
                <td>${book.author}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
