package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddBlogJDBC extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con = null;
		int bId = Integer.parseInt(req.getParameter("bId"));
		String bTitle = req.getParameter("bTitle");
		String bCategory = req.getParameter("bCategory");
		String bDetails = req.getParameter("bDetails");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?createDatabaseIfNotExist=true", "root", "root");
			PreparedStatement pstmt = con
					.prepareStatement("insert blogs(bId, bTitle, bCategory, bDetails) values(?,?,?,?)");
			pstmt.setInt(1, bId);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bCategory);
			pstmt.setString(4, bDetails);
			int rowEffected = pstmt.executeUpdate();

			PrintWriter out = resp.getWriter();
			out.print("<h1>" + rowEffected + " record is added successfully </h1>");
			out.print("<br>");
			out.print("<h2><a href='AddBlog1.jsp'>Back Page</a></h2>");
			out.print("<br>");
			out.print("<h2><a href='DisplayBlogs1'>Blog Dashboard Page</a></h2>");
			out.print("<br>");
			out.print("<h2><a href=\"index.jsp\">Home Page</a></h2>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
