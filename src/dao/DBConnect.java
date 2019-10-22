package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection con;
	
    static
    {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		
    	}
    	catch(Exception  e)
    	{
    		e.getMessage();
    	}
    	
    }
	
	public Connection getConnection() throws SQLException
	{
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/mydb","root","");
		return con;
   }
	
}
