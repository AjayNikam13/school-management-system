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

@WebServlet("/updateStudent")
public class UpdateStudent extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String dob=req.getParameter("dob");
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		
//		System.out.println(id);
//		System.out.println(name);
//		System.out.println(dob);
//		System.out.println(email);
//		System.out.println(pass);
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SProject");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		Students s=new Students();
		
		s.setsId(Integer.parseInt(id));
		s.setsName(name);
		s.setsDob(dob);
		s.setsEmail(email);
		s.setsPass(pass);
		
		et.begin();
		em.merge(s);
		et.commit();
		
		PrintWriter pw=resp.getWriter();
		pw.write("STUDENT UPDATED");
		
		
		RequestDispatcher rd=req.getRequestDispatcher("StudentOption.html");
		rd.include(req, resp);
		resp.setContentType("text/html");

	}
}
