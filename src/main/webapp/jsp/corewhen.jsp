<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--定义一个变量交score，值为85--%>
<c:set var="score" value="85" />

<c:choose>
    <c:when test="${score >= 90}">
        成绩优秀
    </c:when>
    <c:when test="${score >= 80}">
        成绩一般
    </c:when>
    <c:when test="${score >= 70}">
        成绩良好
    </c:when>
    <c:when test="${score >= 60}">
        成绩及格
    </c:when>
</c:choose>


</body>
</html>
