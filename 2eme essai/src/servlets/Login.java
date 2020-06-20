package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LoginBean;
import dao.LoginDao;



public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("your_name");
		String password = request.getParameter("your_pass");
		
		LoginBean LoginBean = new LoginBean();
		
		
		//setting the username and password through the loginBean object then only you can get it in future.
		LoginBean.setUsername(username); 
		LoginBean.setPassword(password);
		 
		//creating the user session
		HttpSession session = request.getSession(true);
		session.setAttribute("username", username);
		
		//creating object for LoginDao. This class contains main logic of the application.
		LoginDao loginDao = new LoginDao(); 
		 
		
		//Calling authenticateUser function
		String userValidate = loginDao.authenticateUser(LoginBean); 
		
		
		if (userValidate.equals("SUCCESS")) {
			//Display the name of the user after login in the jobs.jsp
			request.setAttribute("username",username);
			request.getRequestDispatcher("/WEB-INF/jobs.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errMessage",userValidate);
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
		
		
		 
		
		
	}

}
