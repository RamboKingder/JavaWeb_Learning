package com.lxl.listener;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;

@Deprecated
public class WebApplicationContextUtils {
    public static ApplicationContext getWebApplicationContext(ServletContext context){
        return (ApplicationContext) context.getAttribute("applicationContext");
    }
}