package com.ed.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitSession implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext context=servletContextEvent.getServletContext();
        context.setAttribute("count",0);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
