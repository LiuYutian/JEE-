package cn.lyt.servlet.forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("OneServlet...");
		// ������Ӧͷ
		response.setHeader("aaa", "AAA");
		
		// �������
//		for(int i = 0; i < 1024 * 24 + 2; i++) {
//			// ������Ӧ��		
//			response.getWriter().print("a");
//		}

		/*
		 * ��request�������һ������
		 */
		request.setAttribute("username", "ս��");
			
		// ����ת������ͷ�������塣��ַ�����䣬����������ת
		request.getRequestDispatcher("/TwoServlet").forward(request, response);
		
	}
}
