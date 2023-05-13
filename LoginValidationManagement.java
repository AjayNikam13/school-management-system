package SchoolManagement.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SchoolManagement.dto.Managemet;

@WebServlet("/ValidateManagement")
public class LoginValidationManagement extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("SProject");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select a from Managemet a where a.mEmail=?1 and a.mPass=?2");
		
		q.setParameter(1, email);
		q.setParameter(2, pass);
		
		List<Managemet> management=q.getResultList();
		
		if(management.size()>0)
		{
			RequestDispatcher rd=req.getRequestDispatcher("ManagementOption.html");
			rd.forward(req, resp);	
		}
		else
		{
			PrintWriter pw =resp.getWriter();
			pw.write("Invalid Credentials Enter Again Correct Email And Pass ");
		
			
			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
//			rd.forward(req, resp);
			rd.include(req, resp);
			
			resp.setContentType("text/html");
			
			
		}
		
	}
}
