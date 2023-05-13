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

import com.mysql.cj.Session;

import SchoolManagement.Controller.*;
import SchoolManagement.dto.Teachers;

@WebServlet("/updateTeacher")
public class updateTeacher extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
			String id=req.getParameter("id");
			String name=req.getParameter("name");
			String sub =req.getParameter("subject");
			String age=req.getParameter("age");
			String email=req.getParameter("email");
			String pass=req.getParameter("password");
			
			
//			System.out.println(id);
//			System.out.println(name);
//			System.out.println(sub);
//			System.out.println(age);
//			System.out.println(email);
//			System.out.println(pass);
			

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("SProject");
			EntityManager em=emf.createEntityManager();
			EntityTransaction et=em.getTransaction();
			
			
			Teachers t=new Teachers();
			
			t.settId(Integer.parseInt(id));
			t.settName(name);
			t.settSub(sub);
			t.settAge(Integer.parseInt(age));
			t.settEmail(email);
			t.settPass(pass);
			
			et.begin();
			em.merge(t);
			et.commit();
			
			PrintWriter pw=resp.getWriter();
			pw.write("TEACHER UPDATED");
			
			
			RequestDispatcher rd=req.getRequestDispatcher("TeacherOption.html");
			rd.include(req, resp);
			resp.setContentType("text/html");
	
	}
	
}
