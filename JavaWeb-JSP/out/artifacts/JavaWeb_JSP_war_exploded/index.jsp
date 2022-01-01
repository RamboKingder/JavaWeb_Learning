<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>


  <%-- JSP表达式
  作用：将程序的输出输出到客户端
  <%= (expression)%>
   --%>
  <%= new java.util.Date()%>

  <hr>

  <%-- JSP脚本片段，可以写多行代码 --%>
  <%
    int sum = 0;
    for (int i = 0; i < 100; i++) {
      sum += i;
    }
    out.println("<h1>Sum=" + sum + "</h1>");
  %>

  <hr>

  <%-- 在Java代码块之间可以嵌入HTML元素，在HTML元素中也可以嵌入Java代码 --%>
  <%
    for (int i = 0; i < 5; i++) {
  %>
  <h1>Hello World <%=i%></h1>
  <%
    }
  %>

  <hr>

  <%-- 加!可以在_jsp_Service()方法之外添加代码  --%>
  <%!
    static {
      System.out.println("Loading Servlet......");
    }
    private int globalVar = 0;
    private void lxl(){
      System.out.println("进入了我在_jspService之外定义的一个方法");
    }
  %>

  $END$
  </body>
</html>
