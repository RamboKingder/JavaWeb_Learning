<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

<%--解决中文显示乱码的问题--%>
<%--<%@ page pageEncoding="UTF-8"%>--%>

<%--index.jsp是打开项目后默认进入的页面--%>
<%--这里要用的是项目的路径，需要去寻找而不是直接使用/就能用--%>
<%--${pageContext.request.contextPath}代表当前的项目，这是最推荐的写法--%>
<form action="${pageContext.request.contextPath}/login" method="get">
    用户名：<input type="text" name="username"> <br>
    密 码：<input type="password" name="password"> <br>
    <input type="submit">
</form>

</body>
</html>
