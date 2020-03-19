package com.jane.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context =sce.getServletContext();
        String APP_PATH=context.getContextPath();
        context.setAttribute("APP_PATH",APP_PATH);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
