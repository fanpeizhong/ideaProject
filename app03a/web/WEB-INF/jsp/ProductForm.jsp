<%--
  Created by IntelliJ IDEA.
  User: pzh.fan
  Date: 2017/1/17
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product Form</title>
</head>
<body>
<div id="global">
    <form action="product_save.action" method="post">
        <fieldset>
            <legend>Add a product</legend>
            <p>
                <label for="name">Product name:</label>
                <input type="text" id="name" name="name" tabindex="1">
            </p>
            <p>
                <label for="description">Description:</label>
                <input type="text" id="description" name="description" tabindex="2">
            </p>
            <p>
                <label for="price">Price:</label>
                <input type="text" id="price" name="price" tabindex="3">
            </p>
            <p>
                <input type="reset" tabindex="4">
                <input type="submit" tabindex="5">
            </p>
        </fieldset>
    </form>
</div>
</body>
</html>
