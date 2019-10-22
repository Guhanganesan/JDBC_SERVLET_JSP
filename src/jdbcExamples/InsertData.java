package jdbcExamples;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnect;

@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	
	public static Connection con;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		out.print("Name: "+name);
		out.print("Email :"+email);
		out.print("Pass :"+pass);
		try {
			
			DBConnect db=new DBConnect();
			
			Connection con = db.getConnection();
			
		    String sql="insert into user(name,email,pass) values(?,?,?)";
			
		    PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, pass);
			
		    int check= pst.executeUpdate();
		    
		    if(check >0);
		    {
		    	out.print("Successfully Inserted");
		    }
		    
		} 
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
	}


}
