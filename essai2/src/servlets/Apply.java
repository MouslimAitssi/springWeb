package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ApplyBean;
import dao.Apply_DAO;



public class Apply extends HttpServlet {
	
	private String value;
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	private static final long serialVersionUID = 1L;
      
    public Apply() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		value = request.getParameter("value");
		
		ApplyBean applyBean = new ApplyBean();
		
		applyBean.setNom_societe(value);
		
		Apply_DAO apply_DAO = new Apply_DAO();
		
		ArrayList<String> info_job = apply_DAO.retrieve_info_job(applyBean);
		
		request.setAttribute("company_nom",info_job.get(0));
		request.setAttribute("company_address",info_job.get(1));
		request.setAttribute("company_email",info_job.get(2));
		request.setAttribute("company_period",info_job.get(3));
		request.setAttribute("company_website",info_job.get(4));
		request.setAttribute("company_infos",info_job.get(5));
		request.setAttribute("company_profiles",info_job.get(6));
		request.setAttribute("company_type",info_job.get(7));
		request.setAttribute("company_salary",info_job.get(8));
		request.getRequestDispatcher("/WEB-INF/apply.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
