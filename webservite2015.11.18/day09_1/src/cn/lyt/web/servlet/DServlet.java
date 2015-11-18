package cn.lyt.web.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DServlet extends GenericServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("O(กษ_กษ)O~");
	}
	
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("hello world");
	}

	@Override
	public void destroy() {
		System.out.println("destory()");
	}
}
