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


@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	
	public static Connection con;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		try {
			 DBConnect db= new DBConnect();
			 Connection con= db.getConnection();
			 
		    String sql="update user set name=?, email=?, pass=? where id=?";
		    PreparedStatement pst=con.prepareStatement(sql);
		    pst.setString(1, name);
		    pst.setString(2, email);
		    pst.setString(3, pass);
		    pst.setString(4, id);
		    
		    int value=pst.executeUpdate();
		    if(value>0)
		    {
		    	out.print("Data updated Successfully");
		    }
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}


}
