package SchoolManagement.Controller;

import java.io.IOException;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SchoolManagement.dto.Managemet;
//savenabagenebtdata

@WebServlet("/savemabagenebtdata")
public class SaveManagemet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{

		String id= req.getParameter("id");
		String email= req.getParameter("email");
		String pass=req.getParameter("password");
		
		Managemet m=new Managemet();
		m.setmId(Integer.parseInt(id));
		m.setmEmail(email);
		m.setmPass(pass);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("SProject");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(m);
		et.commit();
	
		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
		rd.forward(req, resp);
		
//		System.out.println("Data Saved");
	}
	
	
}
