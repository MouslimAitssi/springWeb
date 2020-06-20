package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.EntrepriseInfoBean;
import database.Db_connection;

public class EntrepriseInfoDao {
	public String registerEntreprise(EntrepriseInfoBean entrepriseInfoBean) {
		String company_name = entrepriseInfoBean.getCompany_name();
		String company_address = entrepriseInfoBean.getCompany_address();
		String company_email = entrepriseInfoBean.getCompany_email();
		String company_website = entrepriseInfoBean.getCompany_website();
		String project_infos = entrepriseInfoBean.getProject_infos();
		String profiles = entrepriseInfoBean.getProfiles();
		String project_type = entrepriseInfoBean.getProject_type();
		String period = entrepriseInfoBean.getPeriod();
		String salary = entrepriseInfoBean.getSalary();
		
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
		return "Something went wrong there ... Try again please";
		
	} 
}
