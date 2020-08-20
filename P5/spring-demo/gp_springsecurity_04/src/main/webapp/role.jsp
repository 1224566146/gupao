<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/7/14
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>角色管理</h1>
    当前登录的账号:<security:authentication property="principal.username" />
    <security:authorize access="hasAnyRole('ROLE_USER')">
        <a href="#">系统管理</a><br>
    </security:authorize>
    <security:authorize access="hasAnyRole('ROLE_USER1')">
        <a href="#">用户管理</a><br>
    </security:authorize>
    <security:authorize access="hasAnyRole('ROLE_CREATE')">
        <a href="#">订单管理</a><br>
    </security:authorize>
</body>
</html>
