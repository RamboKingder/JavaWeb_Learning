学习黑马SSM教学视频P37-时写的代码

### 1.Spring集成web
ServletContextListener会监听servletContext对象的创建
我们写一个ContextLoaderListener实现ServletContextListener接口
让它在监听到servletContext创建--也就是服务器启动的时候
让它去创建ApplicationContext对象并保存在servletContext对象中
然后编写一个静态方法，传入servletContext对象即可得到ApplicationContext对象

其实上述功能Spring框架已经替我们封装好了
只需呀导入spring-web坐标即可
但还是得在web.xml中去配置这个Spring官方写好的监听器

### 2.SpringMVC