package cn.lyt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 先获取iso错误字符
		 * 在回退，使用utf-8重编
		 */
		String name = request.getParameter("username");
		byte[] b = name.getBytes("iso-8859-1");
		name = new String(b, "utf-8");
		
		System.out.println(name);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1、需要先设置编码格式
		 * 2、获取参数
		 */
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		System.out.println(username);
	}
}
