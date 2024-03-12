package com.blog;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateBlog extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int bId = Integer.parseInt(req.getParameter("bId"));
		String bTitle = req.getParameter("bTitle");
		String bCategory = req.getParameter("bCategory");
		String bDetails = req.getParameter("bDetails");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "root");
			PreparedStatement pstm = con
					.prepareStatement("update blogs set bTitle=?, bCategory=?, bDetails=? where bId=?");
			pstm.setString(1, bTitle);
			pstm.setString(2, bCategory);
			pstm.setString(3, bDetails);
			pstm.setInt(4, bId);
			int rowUp = pstm.executeUpdate();
			PrintWriter out = resp.getWriter();
			out.print("<h1>" + rowUp + " blog records updated...!!!</h1>");
			out.print("<br><br>");
			out.print("<h1><a href='displayBlog'>Back Page</a></h1>");
			out.print("<br><br>");
			out.print("<h1><a href='index.jsp'>Home Page</a></h1>");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
