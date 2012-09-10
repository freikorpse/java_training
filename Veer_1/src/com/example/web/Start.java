package com.example.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Start
 */
public class Start extends CommonBehaivor {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			autentificate(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		play(request, response);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			autentificate(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}

		String name = request.getParameter("name");
		if (name!=null && name.length()<1){
			try {
				redirectToLogin(request, response, "Name is too short");
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
		HttpSession session = request.getSession();
		session.setAttribute("name", name);
		session.setAttribute("play", request.getParameter("play"));
		
		play(request, response);
	}

}
