<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024-05-14
  Time: 오후 5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>list page</h2>
<ul>
    <c:forEach var="dto" items="${dtoList}">
        <li>${dto}</li>
    </c:forEach>
</ul>
</body>
</html>
