package SchoolManagement.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Query;

import SchoolManagement.Controller.*;
import SchoolManagement.dto.Teachers;


@WebServlet("/ValidateTeacher")
public class ValidateTeacher extends HttpServlet
{	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
	
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("SProject");
		   EntityManager em=emf.createEntityManager();
		   
		   javax.persistence.Query q=em.createQuery("select a from Teachers a where a.tEmail = ?1 and a.tPass=?2");
		   
		   q.setParameter(1, email);
		   q.setParameter(2, pass);
		   
		   List<Teachers> teacher=q.getResultList();
		   
		   if(teacher.size()>0)
		   {
			  
			   List<Teachers> teacher1=q.getResultList();
			    Teachers t1=teacher1.get(0);
			   HttpSession hs=req.getSession();
			   hs.setAttribute("teacher", t1);
			   
			   RequestDispatcher rd=req.getRequestDispatcher("TeacherOption.html");
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
		   
			
	}
		
}
