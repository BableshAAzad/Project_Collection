<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Blog Dashboard</title>
<link rel="stylesheet" type="text/css" href="DisplayBlogsCSS.css">
</head>
<body>
<h1>Blog Dashboard</h1>
	<%
	ResultSet rs = (ResultSet) request.getAttribute("blogList");
	%>
	<table border="1" cellspacing="0" cellpadding="5px">
		<thead>
			<tr>
				<th>Blog NO</th>
				<th>Blog Title</th>
				<th>Blog Category</th>
				<th>Blog Details</th>
				<th>Update Blog Details</th>
				<th>Delete Blog from Record</th>
			</tr>
		</thead>
		<tbody>
			<%
			while (rs.next()) {
			%>
			<tr>
				<td class="snoT"><%=rs.getInt("bId")%></td>
				<td class="mnameT"><%=rs.getString("bTitle")%></td>
				<td class="mpriceT"><%=rs.getString("bCategory")%></td>
				<td class="mbrandT"><%=rs.getString("bDetails")%></td>
				<td><a class="updateD" href="updateBlog?bId=<%=rs.getInt("bId")%>">UPDATE</a></td>
				<td><a class="deleteD" href="deleteBlog?bId=<%=rs.getInt("bId")%>">DELETE</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<h2>
		<a href="index.jsp">Home Page</a>
	</h2>

</body>
</html>