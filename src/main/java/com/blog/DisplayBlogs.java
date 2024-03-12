package com.blog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displayBlogs")
public class DisplayBlogs extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "root");
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from blogs");

			req.setAttribute("blogList", resultSet);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("displayBlogs.jsp");
			requestDispatcher.forward(req, resp);
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
