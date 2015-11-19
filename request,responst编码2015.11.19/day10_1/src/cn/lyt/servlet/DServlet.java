package cn.lyt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DServlet extends HttpServlet {

	/**
	 * 定时刷新
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 下面是用来发送响应提！
		 */
		PrintWriter writer = response.getWriter();
		writer.print("欢迎xxx登录成功！5秒后跳转到主页");
		response.setHeader("Refresh", "5;URL=/day10_1/EServlet");
	}
}
