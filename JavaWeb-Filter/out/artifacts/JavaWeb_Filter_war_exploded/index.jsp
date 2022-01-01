<%--
  Created by IntelliJ IDEA.
  User: 17234
  Date: 2022/1/1
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>当前有<span><%= request.getServletContext().getAttribute("OnlineCount")%></span>人在线</h1>
  </body>
</html>
