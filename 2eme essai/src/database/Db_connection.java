package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Db_connection {

	public static Connection createConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/jobs?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"; // /database_name
		String username = "root"; //MySQL username
		String password = "";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url, username, password);
			
			 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
}
