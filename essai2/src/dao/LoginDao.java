package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.LoginBean;
import database.Db_connection;

public class LoginDao {
	
	
	public String authenticateUser(LoginBean loginBean) {
		
		String username = loginBean.getUsername();
		String password = loginBean.getPassword();
		
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String userNameDB = "";
		String passwordDB = "";
		
		
		
		try {
			
			con = Db_connection.createConnection();
			statement = con.createStatement();
			resultSet = statement.executeQuery("select username,password from users");
			
			while(resultSet.next()) // Until next row is present otherwise it return false
			{
				//fetch the values present in database
				userNameDB = resultSet.getString("userName"); 
				passwordDB = resultSet.getString("password");
				if(username.equals(userNameDB) && password.equals(passwordDB))
				{
					// If the user entered values are already present in database, which means user has already registered so return SUCCESS message.
					return "SUCCESS"; 
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "Invalid user";
	}
}
