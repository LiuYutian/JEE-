package cn.lyt.servlet.include;

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
		
		// ������Ӧ��		
		response.getWriter().print("OneServlet...");
		
		// ����ת������ͷ�������塣��ַ�����䣬����������ת
		request.getRequestDispatcher("/include/TwoServlet").include(request, response);
	}
}
