package com.mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/doPost")
public class DoPost extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
    	PrintWriter out =res.getWriter();
    	res.setContentType("text/html");
    	
    	int i=Integer.parseInt(req.getParameter("x"));
    	int j=Integer.parseInt(req.getParameter("y"));
    	out.print(i+j);
    }
    
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
    	PrintWriter out =res.getWriter();
    	res.setContentType("text/html");
    	
    	int i=Integer.parseInt(req.getParameter("x"));
    	int j=Integer.parseInt(req.getParameter("y"));
    	out.print(i+j);
    }
    
    
}
