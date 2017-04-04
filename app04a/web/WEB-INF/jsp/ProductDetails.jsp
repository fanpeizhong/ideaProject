<%--
  Created by IntelliJ IDEA.
  User: pzh.fan
  Date: 2017/1/17
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save Product</title>
    <style type="text/css">@import url(/WEB-INF/css/main.css);</style>
</head>
<body>
<div id="global">
    <h4>The product has been saved.</h4>
    <pre>
            <h5>Details:</h5>
            Product Name:${product.name}
            Descriptio:${product.description}
            Price:${product.price}
        </pre>
</div>
</body>
</html>
