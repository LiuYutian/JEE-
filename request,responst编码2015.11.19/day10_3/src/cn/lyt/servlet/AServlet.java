package cn.lyt.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GET:" + request.getParameter("xxx"));
		System.out.println("GET:" + request.getParameter("yyy"));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String[] hobby = request.getParameterValues("hobby");
		
		System.out.println("username"+username);
		System.out.println("password"+password);
		System.out.println("hobby"+Arrays.toString(hobby));
		
		/*
		 * ���Ի�ȡ�����������������
		 */
		Enumeration names = request.getParameterNames();
		while(names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}
		
		/*
		 * ��ȡ���������������װ��map��
		 */
		Map<String, String[]> map = request.getParameterMap();
		for(String name : map.keySet()) {
			String[] values = map.get(name);
			for(String value : values) {
				System.out.println(value);
			}
			System.out.println();
		}
	}
}
