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
		// ��ȡIP
		String addr = request.getRemoteAddr();
		System.out.println("ip:" + addr);
		
		// ��ȡ����ʽ
		System.out.println("����ʽ��" + request.getMethod());
		
		// ��ȡ����ͷ
		// Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36
		String userAgent = request.getHeader("User-Agent");
		if(userAgent.toLowerCase().contains("chrome")){
			System.out.println("�ȸ�");
		} else if(userAgent.toLowerCase().contains("firefox")) {
			System.out.println("���");
		} else if(userAgent.toLowerCase().contains("msie")) {
			System.out.println("ie");
		}
//		System.out.println(userAgent);
	}
}
