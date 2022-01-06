package com.lxl.web;

import com.lxl.service.UserService;
import com.lxl.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // ServletContext servletContext = this.getServletContext();
        // ApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        // UserService userService = app.getBean(UserServiceImpl.class);
        // userService.service();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
