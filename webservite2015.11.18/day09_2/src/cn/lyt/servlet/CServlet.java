package cn.lyt.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��ȡ������servletContext��ʼ������
 * @author lyt
 *
 */
public class CServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext app = this.getServletContext();
		String value = app.getInitParameter("paramName");
		System.out.println(value);
	}
}
