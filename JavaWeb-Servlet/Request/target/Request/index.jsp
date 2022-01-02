<%--
  Created by IntelliJ IDEA.
  User: 17234
  Date: 2021/12/31
  Time: 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<h1>登录</h1>

<div style="align-content: center">

    <%--这个表单以post方法，提交到/login请求--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名：<input type="text" name="username"> <br>
        密码：<input type="password" name="password"> <br>
        <input type="checkbox" name="hobbies" value="唱歌">唱歌<br>
        <input type="checkbox" name="hobbies" value="女孩">女孩<br>
        <input type="checkbox" name="hobbies" value="代码">代码<br>
        <input type="checkbox" name="hobbies" value="电影">电影<br>

        <input type="submit">
    </form>
</div>

</body>
</html>
