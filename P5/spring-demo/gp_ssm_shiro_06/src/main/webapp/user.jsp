<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<shiro:authenticated>已认证</shiro:authenticated><br>
<shiro:guest>游客</shiro:guest>
<!-- 如果在认证方法返回的 SimpleAuthenticationInfo的第一个参数如果是基本数据类型 直接使用
     如果是对象，那么需要通过 property 对象中的属性-->
<shiro:principal property="name"></shiro:principal>
<h2>用户管理!</h2>
<shiro:hasPermission name="USER_QUERY">
    <h3>用户查询</h3>
</shiro:hasPermission>
<shiro:hasPermission name="USER_CREATE">
    <h3>添加用户</h3>
</shiro:hasPermission>

<shiro:hasPermission name="USER_UPDATE">
    <h3>添加用户</h3>
</shiro:hasPermission>
<shiro:hasPermission name="USER_DELETE">
    <h3>添加用户</h3>
</shiro:hasPermission>

</body>
</html>
