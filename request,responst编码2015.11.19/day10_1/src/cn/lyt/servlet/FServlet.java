package cn.lyt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * ½ûÓÃä¯ÀÀÆ÷»º´æ
 */
public class FServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("pragma", "on-cache");
		response.setDateHeader("expries", -1);
		response.getWriter().print("hello hello");
	}
}
