package com.mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SendRedir1")
public class SendRedir1 extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	
	{
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		int x=Integer.parseInt(req.getParameter("x"));
		int y=Integer.parseInt(req.getParameter("y"));
		
		HttpSession session=req.getSession();
		
	    session.setAttribute("m", x);
        session.setAttribute("n", y);		
		
        
        Cookie cookie =new Cookie("p", x+"");
        res.addCookie(cookie);
        
        
        
	    res.sendRedirect("Result2"); //urlRewriting
	    
				
	}

}

