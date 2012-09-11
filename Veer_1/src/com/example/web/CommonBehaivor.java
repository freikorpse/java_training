package com.example.web;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public abstract class CommonBehaivor extends HttpServlet {

	private static final long serialVersionUID = -3812970845884264635L;

	void autentificate(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		String actual = request.getParameter("token");
		if (session.isNew())
			redirectToLogin(request, response, "Please, introduce yourself: ");
		//check token ring?
		if (actual==null){
			redirectToLogin(request, response, "Error, token is empty. ");
		}
		//token is same?
		String expected = (String) session.getAttribute("token");
		if (expected.equals(actual)){
			redirectToLogin(request, response, "Security: token is not match! ");
		}
		
	}
	
	void redirectToLogin(HttpServletRequest request, HttpServletResponse response, String errorMsg) throws Exception{
		request.setAttribute("errormsg", errorMsg);
		request.setAttribute("title", "Introduce yourself please :)");
		//TODO how will we check for this?
		request.setAttribute("link", response.encodeURL("play"));
		setToken(request);
		
		RequestDispatcher disp = request.getRequestDispatcher("/loginForm.jsp");
		disp.forward(request, response);
	}
	
	void play(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher disp = request.getRequestDispatcher("/startPlay.jsp");
		disp.forward(request, response);
	}
	
	void setToken(HttpServletRequest request) throws Exception{
		String token = getToken();
		request.setAttribute("token", token);
		request.getSession().setAttribute("token", token);
	}
	
	String getToken() throws Exception{
		SecureRandom random;
		try{
			random = SecureRandom.class.cast(getServletContext().getAttribute("tokenGen"));
		} catch (ClassCastException e){
			throw new Exception("Can't generate security token");
		}
		return new BigInteger(130, random).toString(32);
	}
	
	
	
}
