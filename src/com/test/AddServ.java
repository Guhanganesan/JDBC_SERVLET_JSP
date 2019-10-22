package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServ
 */
@WebServlet("/AddServ")
public class AddServ extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int x=Integer.parseInt(req.getParameter("x"));
		int y=Integer.parseInt(req.getParameter("y"));
		
		PrintWriter out = res.getWriter();
		
		out.print(x+y);
	}

}
