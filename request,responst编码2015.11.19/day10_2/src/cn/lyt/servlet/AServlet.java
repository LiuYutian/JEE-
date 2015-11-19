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
		// 获取IP
		String addr = request.getRemoteAddr();
		System.out.println("ip:" + addr);
		
		// 获取请求方式
		System.out.println("请求方式：" + request.getMethod());
		
		// 获取请求头
		// Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.86 Safari/537.36
		String userAgent = request.getHeader("User-Agent");
		if(userAgent.toLowerCase().contains("chrome")){
			System.out.println("谷歌");
		} else if(userAgent.toLowerCase().contains("firefox")) {
			System.out.println("火狐");
		} else if(userAgent.toLowerCase().contains("msie")) {
			System.out.println("ie");
		}
//		System.out.println(userAgent);
	}
}
