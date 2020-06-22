package managedBeans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import database.Db_connection;

@ManagedBean
@RequestScoped
public class EntrepriseController {
	
	private String company_name;
	private String company_address;
	private String company_email;
	private String company_website;
	private String project_infos;
	private String profiles;
	private String project_type;
	private String period;
	private String salary;
	
	
	
	
	
	public String companieInformation() {
		
		String company_name = this.getCompany_name();
		String company_address = this.getCompany_address();
		String company_email = this.getCompany_email();
		String company_website = this.getCompany_website();
		String project_infos = this.getProject_infos();
		String period =this.getPeriod();
		String profile= this.getProfiles();
		String profiles = "Profiles needed are : ";
		String type_job = this.getProject_type();
		String salary = this.getSalary();
		
		if (company_name==null || company_name=="" || company_address==null || company_address=="" || company_email==null || company_email=="")
		{ 
			return "FAILURE";
		}
		else {
			Connection conn = null;
			PreparedStatement preparedStatement = null;
			
			
			try {
				conn = Db_connection.createConnection();
				String query = "insert into companies (company_name,company_address,company_email,company_website,project_infos,profiles,project_type,period,salary) values (?,?,?,?,?,?,?,?,?)";
				preparedStatement = conn.prepareStatement(query);
				preparedStatement.setString(1, company_name);
				preparedStatement.setString(2, company_address);
				preparedStatement.setString(3, company_email);
				preparedStatement.setString(4, company_website);
				preparedStatement.setString(5, project_infos);
				preparedStatement.setString(6, profiles);
				preparedStatement.setString(7, project_type);
				preparedStatement.setString(8, period);
				preparedStatement.setString(9, salary);
				
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
	
	
	
	
	
	
	
	public EntrepriseController(String company_name, String company_address, String company_email,
			String company_website, String project_infos, String profiles, String project_type, String period,
			String salary) {
		super();
		this.company_name = company_name;
		this.company_address = company_address;
		this.company_email = company_email;
		this.company_website = company_website;
		this.project_infos = project_infos;
		this.profiles = profiles;
		this.project_type = project_type;
		this.period = period;
		this.salary = salary;
	}
	
	
	
	
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getProfiles() {
		return profiles;
	}
	public void setProfiles(String profiles) {
		this.profiles = profiles;
	}
	public String getProject_type() {
		return project_type;
	}
	public void setProject_type(String project_type) {
		this.project_type = project_type;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getProject_infos() {
		return project_infos;
	}
	public void setProject_infos(String project_infos) {
		this.project_infos = project_infos;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getCompany_address() {
		return company_address;
	}
	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}
	public String getCompany_email() {
		return company_email;
	}
	public void setCompany_email(String company_email) {
		this.company_email = company_email;
	}
	public String getCompany_website() {
		return company_website;
	}
	public void setCompany_website(String company_website) {
		this.company_website = company_website;
	}

}
