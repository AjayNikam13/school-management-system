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
import javax.servlet.http.HttpSession;

import SchoolManagement.dto.Students;
import SchoolManagement.dto.Teachers;

@WebServlet("/StudentValidation")
public class StudentValidation extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		

		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("SProject");
		   EntityManager em=emf.createEntityManager();
		   
		   javax.persistence.Query q=em.createQuery("select a from Students a where a.sEmail = ?1 and a.sPass=?2");
		   
		   q.setParameter(1, email);
		   q.setParameter(2, pass);
		   
		   List<Students> student=q.getResultList();
		   
		   if(student.size()>0)
		   {
			  
			   List<Students> student1=q.getResultList();
			   Students s1=student1.get(0);
			   HttpSession hs=req.getSession();
			   hs.setAttribute("student", s1);
			   
			   RequestDispatcher rd=req.getRequestDispatcher("StudentOption.html");
			   rd.forward(req, resp);	   
			   
			   
//			   System.out.println(email);
//			   System.out.println(pass);
			   
			   
		   }
		   
		   else
		   {
			   PrintWriter pw=resp.getWriter();
			   pw.write("INVALID CREDENTIALS");
			   RequestDispatcher rd=req.getRequestDispatcher("Login.html");
//				rd.forward(req, resp);
				rd.include(req, resp);
				
				resp.setContentType("text/html");
		   }
		   
		
		
		
		
		
		
		
		
		
//		String email=req.getParameter("email");
//		String pass=req.getParameter("password");
//		
//		EntityManagerFactory emf=Persistence.createEntityManagerFactory("SProject");
//		EntityManager em=emf.createEntityManager();
//		
//		Query q=em.createQuery("select a from Students a where a.sEmail=?1 and a.sPass=?2");
//		
//		q.setParameter(1, email);
//		q.setParameter(2, pass);
//			
//		
//		List<Students> student=q.getResultList();
//		
//		Students s1=student.get(0);
//		
//		HttpSession hs=req.getSession();
//		hs.setAttribute("student", s1);
//		
//		System.out.println(student.size());
//		
//		if(student.size()>0)
//		{
//		
//			RequestDispatcher rd=req.getRequestDispatcher("StudentOption.html");
//			rd.forward(req, resp);
//			
//		}
//		else
//		{
//			PrintWriter pw =resp.getWriter();
//			pw.write("Invalid Credentials Enter Again Correct Email And Pass ");
//		
//			
//			RequestDispatcher rd=req.getRequestDispatcher("Login.html");
////			rd.forward(req, resp);
//			rd.include(req, resp);
//			
//			resp.setContentType("text/html");
//			
//			
//		}

	}
}
