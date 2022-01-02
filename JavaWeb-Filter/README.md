**注意：由于代码中的路径写死了，所以在配置Tomcat服务器时，**

**一定要在Deployment下把Artifact目录设置成/JavaWeb-Filter**

**否则将会产生一堆莫名奇妙的404错误**

### 1.首页

当服务器开启，我们自动跳转到首页的时候，就会显示：当前有1人在线

因为我们创建了一个Session创建监听器，当我们进入index.jsp时，会自动创建一个session并出发这个监听器

然后我们在ServletContext对象中会设置OnlineCount为初值1或者将其值自增

### 2.登录
直接在浏览器url后面加入login.jsp可以进入登录页面

必须提交admin才能登录成功，否则失败，这个请求会提交到/servlet/login来处理

如果提交的时admin，那么在LoginServlet中就会把请求方的SessionID存到Servlet对象中去

然后又将重定向到success.jsp页面中去，显示登录成功！

### 3.注销

注销是通过点击success.jsp页面中的注销按钮，就回去发送到/servlet/logout

在LogoutServlet中，直接就把ServletContext对象的USER_SESSION属性给它移除了

那么之后在权限拦截过滤器中，就会发现取这个是空的，然后就可以进行权限拦截了

### 4.权限拦截过滤器

既然我们已经有了success.jsp这个页面，那我们能不能直接通过url来访问成功页面呢？

能，服务器现在就是这个吊样子，但是这种事情肯定是违背业务逻辑的

因此我们需要写一个权限拦截过滤器，关掉”不登录就能登录成功的功能“

这个拦截器的原理是：看ServletContext对象中键为USER_SESSION的值是否为空

如果为空，说明还没有进行登录，直接拦截并重定向到错误页面去