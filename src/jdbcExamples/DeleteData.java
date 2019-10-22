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


@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	
	public static Connection con;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		
		String id=request.getParameter("id");
		
		try {
			 DBConnect db= new DBConnect();
			 Connection con= db.getConnection();
			 
		    String sql="delete from user where id=?";
		    PreparedStatement pst=con.prepareStatement(sql);
		    pst.setString(1, id);
		    
		    int value=pst.executeUpdate();
		    if(value>0)
		    {
		    	out.print("Data deleted Successfully");
		    }
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}


}
