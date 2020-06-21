package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.RegisterBean;
import dao.RegisterDao;



public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String re_password = request.getParameter("re_pass");
		
		//If one of the field is missing
		if (username==null || username=="" || email==null || email=="" || password==null || password=="" || re_password==null || re_password=="")
		{ 
			request.setAttribute("errMessage","Veuillez remplir tous les champs SVP");
			request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
		}
		
		//If the password lenght is < = 4
		else if (password.length() < 4) {
			request.setAttribute("errMessageLengthPasswd","Le mot de passe doit contenir au moins 4 caractères ");
			request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
		}
		
		//If the password are not the same
		else if (!password.equals(re_password)) {
			request.setAttribute("errMessageDifferentPasswd","Les mots de passe ne sont pas identiques");
			request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
		}
		//If the fields are correct
		else {
			RegisterBean registerBean = new RegisterBean();
			
			registerBean.setUsername(username);
			registerBean.setEmail(email);
			registerBean.setPassword(password);
			registerBean.setRe_password(re_password);
			
			RegisterDao registerDao = new RegisterDao();
			
			String userRegistred = registerDao.registerUser(registerBean);
			
			if (userRegistred.equals("SUCCESS")) {
				request.setAttribute("RegistrationSuccess","you have been successfully registered , please log in now");
				request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
			}
			else {
				request.setAttribute("errRegistration", userRegistred);
				request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
			}
			
			
		}
		
		
	}

}
