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
		// 设置响应头
		response.setHeader("aaa", "AAA");
		
		// 会出问题
//		for(int i = 0; i < 1024 * 24 + 2; i++) {
//			// 设置响应体		
//			response.getWriter().print("a");
//		}

		/*
		 * 向request域中添加一个属性
		 */
		request.setAttribute("username", "战三");
			
		// 请求转发：留头，不留体。地址栏不变，服务器端跳转
		request.getRequestDispatcher("/TwoServlet").forward(request, response);
		
	}
}
