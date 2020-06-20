package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.ApplyBean;
import database.Db_connection;

public class Apply_DAO {
	
	
	public ArrayList<String> retrieve_info_job(ApplyBean applyBean) {
		
		ArrayList<String> info_job = new ArrayList<>();
		
		String nom_societe = applyBean.getNom_societe();
		
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		String name = "";
		String address = "";
		String period = "";
		String email = "";	
		String website = "";
		String infos = "";
		String profiles ="";
		String type = "";
		String salary= "";
		
		try {
			
			con = Db_connection.createConnection();
			statement = con.createStatement();
			String query = "select * from companies where company_name like '%" + nom_societe + "%'";
			resultSet = statement.executeQuery(query);
			
			if (resultSet.next()) {
				
				name = resultSet.getString("company_name");
				info_job.add(name);
				address = resultSet.getString("company_address");
				info_job.add(address);
				email = resultSet.getString("company_email");
				info_job.add(email);
				period = resultSet.getString("period");
				info_job.add(period);
				website = resultSet.getString("company_website");
				info_job.add(website);
				infos = resultSet.getString("project_infos");
				info_job.add(infos);
				profiles = resultSet.getString("profiles");
				info_job.add(profiles);
				type = resultSet.getString("project_type");
				info_job.add(type);
				salary = resultSet.getString("salary");
				info_job.add(salary);
			}
			
			
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return info_job;
	}
}
