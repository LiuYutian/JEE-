package cn.lyt.web.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 模拟GenericServlet
 * @author lyt
 *
 */
public class BServlet implements Servlet {
	private ServletConfig servletConfig;

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	/*
	 * 这个方法一定会在init()方法之后被调用
	 */
	@Override
	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}

	/*
	 * 无用，可以不实现
	 */
	@Override
	public String getServletInfo() {
		return "servlet信息";
	}

	/*
	 * 有Tomcat来调用，并且只调用一次
	 * 它是这些方法中第一个被调用的，他会在构造器之后马上被调用！
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// 把tomcat传递的servletConfig赋值给本来的成员，就是将他进行保存
		this.servletConfig = config;
		init();
	}
	
	public void init() {
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("每次处理请求都会被滴啊用！");
	}

	public ServletContext getServletContext() {
		return servletConfig.getServletContext();
	}
	
	public String getServletName() {
		return servletConfig.getServletName();
	}
	
	public String getInitParameter(String name) {
		return servletConfig.getInitParameter(name);
	}
}
