package com.lxl.listener;

import com.lxl.config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// 在服务器启动时自动加载配置类并且创建Spring容器
@Deprecated
public class ContextLoaderListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        // 获取servletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();

        String configPath = servletContext.getInitParameter("ContextConfigClass");

        ApplicationContext app = null;
        try {
            app = new AnnotationConfigApplicationContext(Class.forName(configPath));
            servletContext.setAttribute("applicationContext", app);
            System.out.println("Spring容器创建完毕......");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("配置类反射加载失败......");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
