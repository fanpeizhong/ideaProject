<%--
  Created by IntelliJ IDEA.
  User: 范培忠
  Date: 2017/2/20
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Big Cities</title>
</head>
<body>
<h1>Captials</h1>
<table border="1">
    <tr>
        <th>国家</th>
        <th>首都</th>
    </tr>
    <c:forEach items="${capitals}" var="capital">
    <tr>
            <td>${capital.key}</td>
            <td>${capital.value}</td>
    </tr>
    </c:forEach>
</table>
<br/>
<br/>
<br/>
<br/>
<table border="1">
    <tr>
        <th>国家</th>
        <th>大城市</th>
    </tr>
    <c:forEach items="${bigCities}" var="bigcity">
        <tr>
            <td>${bigcity.key}</td>
            <td>
            <c:forEach items="${bigcity.value}" var="city" varStatus="status">
                ${city}<c:if test="${!status.last}">,</c:if>
            </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
