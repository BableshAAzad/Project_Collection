package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteBlog")
public class DeleteBlogJDBC extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con = null;
		int bId = Integer.parseInt(req.getParameter("bId"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "root");
			PreparedStatement pstm = con.prepareStatement("delete from blogs where bId=?");
			pstm.setInt(1, bId);
			int rowUp = pstm.executeUpdate();
			PrintWriter out = resp.getWriter();
			out.print("<h1>" + rowUp + " blog record deleted...!!!</h1>");
			out.print("<br><br>");
			out.print("<h1><a href='DisplayBlogs1'>Back Page</a></h1>");
			out.print("<br><br>");
			out.print("<h1><a href='index.jsp'>Home Page</a></h1>");
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
