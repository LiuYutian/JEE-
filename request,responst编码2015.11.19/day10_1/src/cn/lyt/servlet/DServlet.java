package cn.lyt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DServlet extends HttpServlet {

	/**
	 * ��ʱˢ��
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * ����������������Ӧ�ᣡ
		 */
		PrintWriter writer = response.getWriter();
		writer.print("��ӭxxx��¼�ɹ���5�����ת����ҳ");
		response.setHeader("Refresh", "5;URL=/day10_1/EServlet");
	}
}
