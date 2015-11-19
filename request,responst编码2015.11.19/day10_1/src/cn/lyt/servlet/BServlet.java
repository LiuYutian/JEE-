package cn.lyt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 重定向
 * 请求B，相应302，给出location，
 */
public class BServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("BServlet");
		
//		response.setHeader("Location", "/day10_1/CServlet");
//		response.setStatus(302);
		
		response.sendRedirect("http://www.baidu.com");
	}
}
