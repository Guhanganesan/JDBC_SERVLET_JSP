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

@WebServlet("/Result2")
public class Result2 extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		HttpSession session=req.getSession();
		int m=(int) session.getAttribute("m");
		int n=(int) session.getAttribute("n");
		m=m+n;
		out.print("Sum is :"+(m));
		
		
		Cookie cookies[]=req.getCookies();
		
		int temp = 0;
		for(Cookie c: cookies)
		{
			if(c.getName().equals("p"))
			{
				temp=Integer.parseInt(c.getValue());
			}
		}
		out.print("Cookie is: "+temp);
		
	}

}

