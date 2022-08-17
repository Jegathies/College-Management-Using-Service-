package Database;
import java.sql.*;
public class DatabaseConnection {
	static Connection con;
	public static Connection getConnection()
	{
		if(con!=null)
		{
			return con;
		}
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/colleges?characterEncoding=latin1","root","");
			
			if(con == null) {
				throw new Exception();
			}
			
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		

		
		return con;
	}
}
