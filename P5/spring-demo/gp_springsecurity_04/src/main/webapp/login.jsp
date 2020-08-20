<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/7/14
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <h1>登录管理</h1>
        <form action="/login" method="post">
            账号:<input type="text" name="username"><br>
            密码:<input type="password" name="password" ><br>
            <security:csrfInput/>

            <input type="submit" value="登录"><br>
        </form>
<img src="img/t1.png">
</body>
</html>
