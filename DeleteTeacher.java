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

import SchoolManagement.dto.Students;
import SchoolManagement.dto.Teachers;

@WebServlet("/deleteTeacher")
public class DeleteTeacher extends HttpServlet
{	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String id=req.getParameter("id");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("SProject");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Teachers t=em.find(Teachers.class, Integer.parseInt(id));
		
		et.begin();
		em.remove(t);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("TEACHER DELETED");
		
		RequestDispatcher rd=req.getRequestDispatcher("ManagementOption.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
	}
	
}	
