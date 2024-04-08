<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Blog page</title>
<link rel="stylesheet" type="text/css" href="BlogCSS.css">
</head>
<body>
	<section>
		<h1>Add New Blog in Database</h1>
		<form action="AddBlog1" method="post">
			<input type="number" name="bId" placeholder="Enter Blog ID" /><br>
			<br> <input type="text" name="bTitle"
				placeholder="Enter Blog Title" /><br> <br> <input
				type="text" name="bCategory" placeholder="Enter Category" /><br>
			<br>
			<textarea name="bDetails" rows="5"
				placeholder="Enter Details about your blog..."></textarea>
			<br> <br> <input type="submit" value="ADD BLOG" />
		</form>
		<br> <br>
		<h2>
			<a href="index.jsp">Home Page</a>
		</h2>
	</section>
</body>
</html>