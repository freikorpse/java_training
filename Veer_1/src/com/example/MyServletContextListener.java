package com.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.example.model.Dog;

//@WebListener
public class MyServletContextListener implements ServletContextListener {

	static int count = 0;
	
    public void contextInitialized(ServletContextEvent event) {
    	count++;
        ServletContext sc = event.getServletContext();
        String breed = (String) sc.getInitParameter("breed");
    	Dog dog = new Dog(breed);
    	System.out.print("\007");
    	sc.setAttribute("dog", dog);
    	sc.setAttribute("count", count);
    }

    public void contextDestroyed(ServletContextEvent event) {
        Object object = event.getServletContext().getAttribute("dog");
        Dog dog = Dog.class.cast(object);
        System.out.print("<p> here is a dog: "+dog.getBreed()+" </p>");
		System.err.println("Context has been destroyed.");
    }
	
}
