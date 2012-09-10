package com.example.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Start
 */
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.isNew()){
			redirectToLogin(request, response, "Please, introduce yourself: ");
		} else {
			redirectToPlay(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		if (name!=null && name.length()<1){
			redirectToLogin(request, response, "Name is too short");
		}
	}

	private void redirectToLogin(HttpServletRequest request, HttpServletResponse response, String errorMsg) throws ServletException, IOException{
		request.setAttribute("errormsg", errorMsg);
		RequestDispatcher disp = request.getRequestDispatcher("/loginForm.jsp");
		disp.forward(request, response);
	}
	
	private void redirectToPlay(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		RequestDispatcher disp = request.getRequestDispatcher("/startPlay.jsp");
		disp.forward(request, response);
	}

}
