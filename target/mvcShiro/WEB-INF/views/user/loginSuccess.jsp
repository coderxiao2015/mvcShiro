<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    用户权限
    <shiro:hasPermission name="create">
        创建
    </shiro:hasPermission>

    <shiro:hasPermission name="delete">
        删除
    </shiro:hasPermission>

    <shiro:hasPermission name="update">
        更新
    </shiro:hasPermission>

    <shiro:hasPermission name="select">
       查询
    </shiro:hasPermission>
</body>
</html>
