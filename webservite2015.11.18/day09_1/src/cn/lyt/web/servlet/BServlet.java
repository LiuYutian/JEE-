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
 * ģ��GenericServlet
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
	 * �������һ������init()����֮�󱻵���
	 */
	@Override
	public ServletConfig getServletConfig() {
		return this.servletConfig;
	}

	/*
	 * ���ã����Բ�ʵ��
	 */
	@Override
	public String getServletInfo() {
		return "servlet��Ϣ";
	}

	/*
	 * ��Tomcat�����ã�����ֻ����һ��
	 * ������Щ�����е�һ�������õģ������ڹ�����֮�����ϱ����ã�
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// ��tomcat���ݵ�servletConfig��ֵ�������ĳ�Ա�����ǽ������б���
		this.servletConfig = config;
		init();
	}
	
	public void init() {
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		System.out.println("ÿ�δ������󶼻ᱻ�ΰ��ã�");
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
