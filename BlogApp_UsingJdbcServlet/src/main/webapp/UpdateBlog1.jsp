<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Blog Data</title>
<link rel="stylesheet" type="text/css" href="BlogCSS.css">
</head>
<body>
<section>
	<h1>Update Blog Records</h1>
	<% ResultSet rsltSet = (ResultSet) request.getAttribute("existingBlog");
	while(rsltSet.next()){
	%>
	<form action="UpdateBlogJDBC" method="post">
	  <input type="number" value="<%=rsltSet.getInt("bId")%>" name="bId" readonly="true" /><br><br>
      <input type="text" value="<%=rsltSet.getString("bTitle")%>" name="bTitle" placeholder="Enter Blog title"/><br><br>
      <input type="text" value="<%=rsltSet.getString("bCategory")%>" name="bCategory" placeholder="Enter Blog category"/><br><br>
      <textarea name="bDetails" rows="5" placeholder="Enter Details about your blog..."><%=rsltSet.getString("bDetails")%></textarea><br><br>
      <input type="submit" value="UPDATE"/>
    </form>
    <%}%>
<br>
<h3><a href="DisplayBlogs1">Back Page</a></h3>
<h3><a href="index.jsp">Home Page</a></h3>
</section>
</body>
</html>