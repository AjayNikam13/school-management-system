<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="SchoolManagement.dto.Assignment"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.Query"%>
<%@page import="SchoolManagement.dto.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	.I
		{
			align-self :center;			
			color: blue;
			background-color: activeborder;
		}
	</style>
</head>
<body bgcolor="grey">

	<% Students s=(Students)session.getAttribute("student");
		
	

EntityManagerFactory emf=Persistence.createEntityManagerFactory("SProject");
EntityManager em=emf.createEntityManager();
EntityTransaction et=em.getTransaction();
 int sId=s.getsId();
// String sName=s1.getName();
//Query q=em.createQuery("select a from Assignment a where a.sId=?1");
Query q=em.createQuery("select a from Assignment a where a.sId =?1");
 q.setParameter(1,sId);
 //List<Assignment>assignment2=q.getResultList();
 
 List<Assignment>assignment=q.getResultList();
 Assignment	as1=assignment.get(0);
%>

<table align="center" border="2" bordercolore="blue" cellpadding="20" style="background-color: yellow;">
	<caption style="color: red; font-size: xx-large; font-size-adjust: inherit; font-family: cursive; text-shadow: 2px 2px black ">Assignment Table</caption>
	<tr bgcolor="#DEB887">
    <th>Student ID</th>
     <th>Assignment ID</th>
      <th>Name</th>
       <th>Marks</th>
  </tr>
     <%for(Assignment as3:assignment) {%>
     <tr>
      <td><%=as3.getsId() %></td>
      <td><%=as3.getaId() %></td>
      <td><%=as3.getaName() %></td>
      <td><%=as3.getaMarks()%></td>
     </tr>
      
     <%} %>
</table>
	
	

</body>
</html>