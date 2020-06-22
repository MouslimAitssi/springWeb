package managedBeans;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import database.Db_connection;

@ManagedBean
@SessionScoped
public class LoginController {
	
	private String name;
	private String password;
	
	public LoginController() {
		
	}
	
	public LoginController(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	public String authenticateUser() {
		
		String username = this.getName();
		String password = this.getPassword();
		
		
		
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
				userNameDB = resultSet.getString("username"); 
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
		
		
		return "FAILURE";
	}
	
	public void logout() {
    	FacesContext context = FacesContext.getCurrentInstance();
    	context.getExternalContext().invalidateSession();
        try {
			context.getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	
	
	

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + "]";
	}
	
	
	
	
	

}
