<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2024-05-14
  Time: 오후 3:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>NUM1 : ${param.num1}</h2>
    <h2>NUM2 : ${param.num2}</h2>
    <h2>SUM : ${Integer.parseInt(param.num1) + Integer.parseInt(param.num2)} </h2>

</body>
</html>
