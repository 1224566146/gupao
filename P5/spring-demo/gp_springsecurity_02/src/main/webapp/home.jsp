<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/7/14
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>HOME</title>
</head>
<body>
    <h1>HOME页面</h1>
    <form method="post" action="/logout">
        <security:csrfInput/>
        <input type="submit" value="注销">
    </form>
</body>
</html>
