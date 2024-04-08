<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head>
<body>
<h1>Add New Student</h1>
<form action="studentAdd" method="post">
  <input type="number" name="studentId" placeholder="Student Id" /><br><br>
  <input type="text" name="studentName" placeholder="Student Name" /><br><br>
  <input type="email" name="studentEmail" placeholder="Student Email" /><br><br>
  <input type="password" name="studentPassword" placeholder="Student Password" /><br><br>
  <input type="submit" value="Register Student" />
</form>
</body>
</html>