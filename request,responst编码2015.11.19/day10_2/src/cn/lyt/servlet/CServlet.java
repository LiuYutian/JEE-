package cn.lyt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().print(request.getScheme() + "<br/>");	// ��ȡ����Э��
		response.getWriter().print(request.getServerName() + "<br/>");	// ��ȡ����������
		response.getWriter().print(request.getServerPort() + "<br/>"); 	// ��ȡ�������˿ں�
		response.getWriter().print(request.getContextPath() + "<br/>");	// ��ȡ��Ŀ����
		response.getWriter().print(request.getServerPort() + "<br/>");	// ��ȡservlet·��
		response.getWriter().print(request.getQueryString() + "<br/>");	// ��ȡ��������
		response.getWriter().print(request.getRequestURI() + "<br/>");	// ��ȡ����URI
		response.getWriter().print(request.getRequestURL() + "<br/>");	// ��ȡ����URL
	}
}
