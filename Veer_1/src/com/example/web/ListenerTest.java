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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<br />");
		Dog dog = Dog.class.cast(request.getServletContext().getAttribute("dog"));
		out.println(dog.growl());
	}

}
