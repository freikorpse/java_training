package com.example;

import java.security.SecureRandom;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//@WebListener
public class MyServletContextListener implements ServletContextListener {

	private SecureRandom random = new SecureRandom();
	
    public void contextInitialized(ServletContextEvent event) {
    	ServletContext context = event.getServletContext();
    	context.setAttribute("tokenGen", random);
    }

    public void contextDestroyed(ServletContextEvent event) {
        
    }
	
}
