package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.Dog;

/**
 * Servlet implementation class ListenerTest
 */
@WebServlet(description = "simple listenter to test listeners", urlPatterns = { "/ListenerTest" })
public class ListenerTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static int servletCount = 0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		servletCount++;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int count = Integer.class.cast(request.getServletContext().getAttribute("count"));
		out.println("<p>this was used: "+count+" times.</p>");
		out.println("<p>servlet was called: "+servletCount+" times.</p>");
		out.println("<br />");
		Dog dog = Dog.class.cast(request.getServletContext().getAttribute("dog"));
		out.println("<p>"+dog.growl()+"</p>");
		out.flush();
    	//throw new RuntimeException("gopa!!!");
	}

}
