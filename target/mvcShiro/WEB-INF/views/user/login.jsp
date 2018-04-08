
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
<form action="/shiro/doLogin" >
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" value="" name="loginName"></td>
            </tr>
            <tr>
                <td>用户名：</td>
                <td><input type="password" value="" name="password"></td>
            </tr>
        </table>
    <input type="submit" value="登录">
</form>
</body>
</html>
