package SchoolManagement.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SchoolManagement.dto.*;

@WebServlet("/addTeachers")
public class AddTeacher extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	

		String id = req.getParameter("id");
		String name=req.getParameter("name");
		String subject =req.getParameter("subject");
		String age=req.getParameter("age");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Teachers t=new Teachers();
		t.settId(Integer.parseInt(id));
		t.settName(name);
		t.settSub(subject);
		t.settAge(Integer.parseInt(age));
		t.settEmail(email);
		t.settPass(password);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("SProject");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		em.persist(t);
		et.commit();
	
		PrintWriter pw=resp.getWriter();
		pw.write("TEACHER ADDED IN DATABASE");
	}
}
