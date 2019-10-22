package com.mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Result1")
public class Result1 extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	
	{
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		//out.print("Hello");
		
		int i=Integer.parseInt(req.getParameter("x"));
		int j=Integer.parseInt(req.getParameter("y"));
		out.println("Sum is: "+(i+j));		
	}

}

