package managedBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import database.Db_connection;

@ManagedBean
@RequestScoped
public class RegisterController {
	
	private String username;
	private String email;
	private String password;
	private String re_password;
	
	
	public RegisterController() {
	}
	
	
	public String registration() {
		String username = this.getUsername();
		String email = this.getEmail();
		String password = this.getPassword();
		String re_password = this.getRe_password();
		
		System.out.println(username+" "+email);
		
		if (username==null || username=="" || email==null || email=="" || password==null || password=="" || re_password==null || re_password=="")
		{ 
			return "FAILURE";
		}
		
		
		//If the password are not the same
		else if (!password.equals(re_password)) {
			return "FAILURE";
		}
		//If the fields are correct
		else {
			
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
			return "FAILURE";
		}
	}
	
	public RegisterController(String username, String email, String password, String re_password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.re_password = re_password;
		
		
		
		
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRe_password() {
		return re_password;
	}
	public void setRe_password(String re_password) {
		this.re_password = re_password;
	}




	@Override
	public String toString() {
		return "RegisterController [username=" + username + ", email=" + email + ", password=" + password
				+ ", re_password=" + re_password + "]";
	}
	
	
	
	
	
	
	
}
