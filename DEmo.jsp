<%@page import="SchoolManagement.dto.Assignment"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityTransaction"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("SProject");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	Query q=em.createQuery("select a from Assignment a where aId=2");
	
	List<Assignment> as=q.getResultList();
	
	for(Assignment a:as)
	{
		out.println(a.getsId());
     	out.println(a.getaId());
     	out.println(a.getaName());
     	out.println(a.getaMarks());
	}

%>
</body>
</html>