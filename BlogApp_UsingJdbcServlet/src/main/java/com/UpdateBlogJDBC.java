package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateBlog")
public class UpdateBlogJDBC extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog", "root", "root");
			PreparedStatement pstm = con.prepareStatement("select * from blogs where bId=?");
			int bId = Integer.parseInt(req.getParameter("bId"));
			pstm.setInt(1, bId);
			ResultSet rs = pstm.executeQuery();
			req.setAttribute("existingBlog", rs);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("UpdateBlog1.jsp");
			requestDispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
