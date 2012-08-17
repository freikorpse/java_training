package com.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.example.model.Dog;

//@WebListener
public class MyServletContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public MyServletContextListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();
        String breed = (String) sc.getInitParameter("breed");
    	Dog dog = new Dog(breed);
    	System.out.print("\007");
    	sc.setAttribute("dog", dog);
    }

    public void contextDestroyed(ServletContextEvent event) {
        Object object = event.getServletContext().getAttribute("dog");
        Dog dog = Dog.class.cast(object);
        System.err.println(dog.bark());
        try {
        	System.out.print("\007");
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			throw new RuntimeException("oops!");
		} finally {
			System.err.println("shut up");
		}
    }
	
}
