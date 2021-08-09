

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/JDBC_Demo";

		String userName = "root";
		
		String password = "admin";
		
		try {
			System.out.println(" Connecting to database");
			
			Connection myConn = DriverManager.getConnection(jdbcUrl,userName, password);
			
			System.out.println("connection successful");
			myConn.close();
		}
		
		catch(Exception exc) {
			System.out.println("Error connecting db");
			exc.printStackTrace();
		}
 
	}

}
