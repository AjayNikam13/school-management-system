package SchoolManagement.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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

import SchoolManagement.dto.Assignment;
import SchoolManagement.dto.Students;

@WebServlet("/addAssignment")
public class AddAssignment extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	
		String Sid = req.getParameter("Sid");
		String Aid = req.getParameter("Aid");
		String Aname = req.getParameter("Aname");
		String marks = req.getParameter("marks");
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("SProject");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		
		Assignment a=new Assignment();
		a.setsId(Integer.parseInt(Sid));
		a.setaId(Integer.parseInt(Aid));
		a.setaName(Aname);
		a.setaMarks(Integer.parseInt(marks));
		
		et.begin();
		em.persist(a);
		et.commit();
		
		
		PrintWriter pw=resp.getWriter();
		pw.write("ASSIGNMENT ADDED");
		
		RequestDispatcher rd=req.getRequestDispatcher("TeacherOption.html");
		rd.include(req, resp);
		resp.setContentType("text/html");
		
		
		
		
		
		
		
////		Students s=em.find(Students.class, Integer.parseInt(Sid));
//		
//		Assignment a=new Assignment();
//		a.setaId(Integer.parseInt(Aid));
//		a.setaName(Aname);
//		a.setaMarks(Integer.parseInt(marks));
//			
//		List<Assignment> ass=new ArrayList<Assignment>();
//		ass.add(a);
//		
////		s.setAssignment(ass);
////		a.setStudents(s);
//		
//		et.begin();
//		em.persist(a);
//		em.persist(s);
//		et.commit();
//	
////		a.setStudents(s);
		
	
		
		
		
	
	
	}
}
