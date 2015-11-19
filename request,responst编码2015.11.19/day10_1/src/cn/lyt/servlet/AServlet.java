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
		response.setHeader("aaa", "AAA");
		// 缓存时间
		response.setDateHeader("expires", 1000 * 60 * 60 * 24);
		response.setIntHeader("Content-Length", 888);
		response.sendError(404, "您访问的资源不存在");
	}
}
