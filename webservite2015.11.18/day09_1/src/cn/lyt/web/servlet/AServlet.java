package cn.lyt.web.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// servlet 方法不由我们来调用，而是由服务器来调用
// servlet 对象也不用我们来创建
// servlet是单例的，不会创建多个实例
/**
 * 查看servlet接口中的方法
 * @author lyt
 *
 */
public class AServlet implements Servlet {

	/*
	 * 它是声明周期方法：是由tomcat调用
	 * 它会在servlet被销毁之前调用，并且它只会被调用一次
	 * 在服务器停止的时候会调用
	 */
	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	/*
	 * 获取servlet的配置信息
	 */
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig");
		return null;
	}
	
	/*
	 * 获取servlet的信息
	 */
	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo");
		return "我是一个快乐的servlet";
	}
	
	/*
	 * 它是声明周期方法
	 * 它会在Servlet对象创建之后马上执行，并且只执行一次（出生之后）
	 * 在应用第一次被请求的时候，调用init并不会随着tomcat的打开而启动
	 */
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init");
		
		/*
		 * 获取初始化参数
		 */
		System.out.println(servletConfig.getInitParameter("p1"));
		System.out.println(servletConfig.getInitParameter("p2"));
		
		/*
		 * 获取所有初始化参数的名称
		 */
		Enumeration e = servletConfig.getInitParameterNames();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}

	/*
	 * 它是声明周期方法
	 * 它会被调用多次
	 * 每次处理请求都是在调用这个方法
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("service");
	}
}
