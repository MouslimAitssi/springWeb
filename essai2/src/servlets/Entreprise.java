package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.EntrepriseInfoBean;
import dao.EntrepriseInfoDao;


public class Entreprise extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Entreprise() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/WEB-INF/entreprise.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String company_name = request.getParameter("company_name");
		String company_address = request.getParameter("company_address");
		String company_email = request.getParameter("company_email");
		String company_website = request.getParameter("company_website");
		String project_infos = request.getParameter("project_infos");
		String period =request.getParameter("inter_period");
		String profile[] = request.getParameterValues("profiles");
		String profiles = "Profiles needed are : ";
		String type_job = request.getParameter("typeofjob");
		String salary = request.getParameter("salary");
		
		//If one of the field is missing
		if (company_name==null || company_name=="" || company_address==null || company_address=="" || company_email==null || company_email=="")
		{ 
			request.setAttribute("errMessage","Veuillez remplir tous les champs SVP");
			request.getRequestDispatcher("/WEB-INF/entreprise.jsp").forward(request, response);
		}
		//If the fields are correct
		else {
			EntrepriseInfoBean EntrepriseInfoBean = new EntrepriseInfoBean();
			
			EntrepriseInfoBean.setCompany_name(company_name);
			EntrepriseInfoBean.setCompany_address(company_address);
			EntrepriseInfoBean.setCompany_email(company_email);
			EntrepriseInfoBean.setCompany_website(company_website);
			EntrepriseInfoBean.setProject_infos(project_infos);
			for (int i = 0; i < profile.length; i++) {
				profiles += profile[i] + " ";
			}
			if("Job".equals(type_job)) {
				EntrepriseInfoBean.setProject_type("Job");
				EntrepriseInfoBean.setPeriod("Full-Time");
			}
			else {
				EntrepriseInfoBean.setProject_type("Internship");
				EntrepriseInfoBean.setPeriod(period);
			}
			EntrepriseInfoBean.setSalary(salary);
			EntrepriseInfoBean.setProfiles(profiles);
			
			EntrepriseInfoDao EntrepriseInfoDao = new EntrepriseInfoDao();
			
			String EntrepriseRegistred = EntrepriseInfoDao.registerEntreprise(EntrepriseInfoBean);
			
			if (EntrepriseRegistred.equals("SUCCESS")) {
				request.setAttribute("RegistrationSuccess","you have been successfully EntrepriseInfoed , please log in now");
				request.getRequestDispatcher("/WEB-INF/jobs.jsp").forward(request, response);
			}
			else {
				request.setAttribute("errRegistration", EntrepriseRegistred);
				request.getRequestDispatcher("/WEB-INF/entreprise.jsp").forward(request, response);
			}
			
		}
	}

}
