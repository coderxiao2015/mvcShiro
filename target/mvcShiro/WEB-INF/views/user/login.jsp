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
            <%--记住我功能--%>
            <tr>
                <td>
                    <%--这里为了方便我默认将value设置为true,shiro对value 的判断除了true这个状态位还有：t，1，enabled，y，yes，on这几种--%>
                    <input type="checkbox" value="true" name="rememberMe">
                </td>
                <td>记住我</td>
            </tr>
        </table>
    <input type="submit" value="登录">
</form>
</body>
</html>
