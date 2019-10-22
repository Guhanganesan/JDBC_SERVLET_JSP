package jdbcExamples;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnect;


@WebServlet("/RetrieveData")
public class RetrieveData extends HttpServlet {
	
	public static Connection con;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		try {
			 DBConnect db= new DBConnect();
			 Connection con= db.getConnection();
			 
		    String sql="select * from user where email=? and pass=?";
		    PreparedStatement pst=con.prepareStatement(sql);
		    pst.setString(1, email);
		    pst.setString(2, pass);
		    ResultSet rs=pst.executeQuery();
		    while(rs.next())
		    {
		    	out.println("Id :"+rs.getString("id"));
		    	out.println("Name:"+rs.getString("name"));
				out.println("Email:"+rs.getString("email"));
				out.println("Pass: "+rs.getString("pass"));
		    }
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}


}
