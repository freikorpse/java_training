package com.example.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.BeerExpert;

public class BeerSelect extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		BeerExpert ex = new BeerExpert();
		List<String> list = ex.getBrands(request.getParameter("color"));
		
		/*out.println("Beer Selection Advice<br>");
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			out.print("<br>try: " + it.next());
		}*/
		
		request.setAttribute("styles", list);
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		view.forward(request, response);
	}

}