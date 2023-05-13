package SchoolManagement.Controller;

import java.io.IOException;
import java.io.PrintWriter;

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
import SchoolManagement.dto.Students;

@WebServlet("/addStudent")
public class AddStudent extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String id = req.getParameter("id");
		String name=req.getParameter("name");
		String dob=req.getParameter("Dob");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Students s=new Students();
		s.setsId(Integer.parseInt(id));
		s.setsName(name);
		s.setsDob(dob);
		s.setsEmail(email);
		s.setsPass(password);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("SProject");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(s);
		et.commit();
	
		PrintWriter pw=resp.getWriter();
		pw.write("STUDENT ADDED IN DATABASE");
		
		RequestDispatcher rd=req.getRequestDispatcher("ManagementOption.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
		
		
		
	
		
	}
}
