<%@page import="com.mvc.entity.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<Student> list = (List) request.getAttribute("list"); %>
	<h1>Student Dashboard</h1>
	<table border="1" cellspacing="0" cellpadding="5px">
		<thead>
		<tr>
			<th>StudentId</th>
			<th>StudentName</th>
			<th>StudentEmail</th>
			<th>StudentPassword</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		</thead>
		<tbody>
		<%
		for (Student std : list) {
		%>
		<tr>
			<td><%=std.getStudentId()%></td>
			<td><%=std.getStudentName()%></td>
			<td><%=std.getStudentEmail()%></td>
			<td><%=std.getStudentPassword()%></td>
			<td><a href="updateStudent?studentId=<%=std.getStudentId()%>" >UPDATE</a></td>
			<td><a href="deleteStudent?studentId=<%=std.getStudentId()%>">DELETE</a></td>
		</tr>
		<%
		}
		%>
		</tbody>
	</table>
	<h2>
		<a href="addStudent.jsp">Add Student</a>
	</h2>
	<h2>
		<a href="index.jsp">Home Page</a>
	</h2>
</body>
</html>