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

import SchoolManagement.dto.Managemet;
import SchoolManagement.dto.Students;
import SchoolManagement.dto.Teachers;

@WebServlet("/select")
public class SelectRole extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String role=req.getParameter("role");
		
		if(role.equals("management"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("/ValidateManagement");
			rd.forward(req, resp);
		}
		else if(role.equals("teacher"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("/ValidateTeacher");
			rd.forward(req, resp);
		}
		else if(role.equals("student"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("/StudentValidation");
			rd.forward(req, resp);
			
			
		}
			
	}
}






//else if(role.equals("teacher"))
//{
////	RequestDispatcher rd=req.getRequestDispatcher("/ValidateTeacher");
////	rd.forward(req, resp);
//	
//	RequestDispatcher rd=req.getRequestDispatcher("/ValidateTeacher");
//	rd.forward(req, resp);
//	
////	String email = req.getParameter("email");
////	String pass = req.getParameter("password");
////	
////	EntityManagerFactory emf=Persistence.createEntityManagerFactory("SProject");
////	EntityManager em=emf.createEntityManager();
////	
////	Query q = em.createQuery("select a from Teachers a where a.tEmail = ?1 and a.tPass=?2");
////	q.setParameter(1, email);
////	q.setParameter(2, pass);
////	
////	List<Teachers> teachers=q.getResultList();
////	
//////	Teachers t1=teachers.get(0);
//////		
//////	HttpSession hs=req.getSession();
//////		hs.setAttribute("teacher", t1);
//////	
////	
////	if(teachers.size()>0)
////	{
////		RequestDispatcher rd=req.getRequestDispatcher("/ValidateTeacher");
////		rd.forward(req, resp);
////	}
////	else
////	{
////		PrintWriter pw = resp.getWriter();
////		pw.write("INVALID CREDENTIALS");
////		
////		RequestDispatcher rd =req.getRequestDispatcher("Login.html");
////		//rd.forward(req, resp);
////		rd.include(req, resp);
////		
////		resp.setContentType("text/html");
////	}
//}



