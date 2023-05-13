<%@page import="SchoolManagement.dto.Teachers"%>
<%@page import="SchoolManagement.Controller.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
		.I
		{
			background-color: yellow;
			width: "60";
			
		}
		.I:hover
		{
			text-shadow :red;
			background-color: aqua;
			display: block;
			
		}
		
	</style>
</head>
<body bgcolor="grey">
	<% Teachers t=(Teachers)session.getAttribute("teacher"); %>
	
	<h1 align="center" style="color: red; font-family: cursive; font-size: 20px; text-shadow: 2px 2px black"><u>*&#129333; Enter Teacher New Detail's*</u> </h1>
	
	
	
	
	<table border="2" align ="center" bordercolor="blue" height="300" width="400">
	<tr bgcolor="#DEB887">
		<td>
		
		<form action="updateTeacher" method="post">
		
		<table border="1" cellpadding="8" height="300" width="400">
				<tr>
					<td>Id</td>
					<td><input type="number" name="id" value="<%= t.gettId()%>"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="<%= t.gettName() %> "></td>
				</tr>
				<tr>
					<td>Subject</td>
					<td><input type="text" name="subject" value="<%=t.gettSub() %>"></td>
				</tr>
				<tr>
					<td>Age</td>
					<td><input type="number" name="age" value="<%=t.gettAge() %>"></td>
				</tr>
				<tr>
					<td>Email <sup> <font color="red">*</font></sup></td>
					<td><input type="email" name="email" value="<%= t.gettEmail() %>"> </td>
				</tr>
				<tr>
					<td>Password <sup> <font color="red">*</font></sup></td>
					<td><input type="password" name="password" value="<%=t.gettPass() %>"></td>
				</tr>
	
		</table>
		
		<table align="center">
				<tr>
					<td ><input type="submit" value="Update" class="I"></td>
					<td ><input type="reset" value="Reset" class="I"></td> 
					<td><button class="I"> <a href="Login.html"> Logout </a> </button></td> 
					
				</tr>
				
			</table>

		</form>
	
	
	</td>
	</tr>	
</table>	
</body>
</html>