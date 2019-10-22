package com.mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SendRedir")
public class SendRedir extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	
	{
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		int x=Integer.parseInt(req.getParameter("x"));
		int y=Integer.parseInt(req.getParameter("y"));
		
	    res.sendRedirect("Result1?x="+x+"&y="+y); //urlRewriting
	    
				
	}

}

