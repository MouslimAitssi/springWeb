package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.RegisterBean;
import database.Db_connection;

public class RegisterDao {
	public String registerUser(RegisterBean registerBean) {
		String username = registerBean.getUsername();
		String email = registerBean.getEmail();
		String password = registerBean.getPassword();
		
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		
		try {
			conn = Db_connection.createConnection();
			String query = "insert into users (username,email,password) values (?,?,?)";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			
			int flag = preparedStatement.executeUpdate();
			
			if (flag != 0) {
				return "SUCCESS";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "Something went wrong there ... Try again please";
		
	} 
}
