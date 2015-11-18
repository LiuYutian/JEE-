package cn.lyt.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ʹ��servletContext��ȡ��Դ·��
 * @author lyt
 *
 */
public class DServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * ���õ��������̷���·��
		 */
		String path = this.getServletContext().getRealPath("/index.jsp");
		System.out.println(path);
		/*
		 * ��ȡ��Դ��·�����ڴ�������������
		 */
		InputStream input = this.getServletContext().getResourceAsStream("/index.jsp");
		
		/*
		 * ��ȡ��ǰ·����������Դ��·��
		 */
		Set<String> paths  = this.getServletContext().getResourcePaths("/WEB-INF");
		System.out.println(paths);
		
	}
}