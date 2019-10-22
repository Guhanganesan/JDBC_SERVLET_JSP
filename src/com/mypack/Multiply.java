package com.mypack;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Multiply")
public class Multiply extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		PrintWriter out =res.getWriter();
		res.setContentType("text/html");
		int result=(int) req.getAttribute("sq");
		
		out.print(result);
	}

}
