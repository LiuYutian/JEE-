package cn.lyt.web.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

// servlet �����������������ã������ɷ�����������
// servlet ����Ҳ��������������
// servlet�ǵ����ģ����ᴴ�����ʵ��
/**
 * �鿴servlet�ӿ��еķ���
 * @author lyt
 *
 */
public class AServlet implements Servlet {

	/*
	 * �����������ڷ���������tomcat����
	 * ������servlet������֮ǰ���ã�������ֻ�ᱻ����һ��
	 * �ڷ�����ֹͣ��ʱ������
	 */
	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	/*
	 * ��ȡservlet��������Ϣ
	 */
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig");
		return null;
	}
	
	/*
	 * ��ȡservlet����Ϣ
	 */
	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo");
		return "����һ�����ֵ�servlet";
	}
	
	/*
	 * �����������ڷ���
	 * ������Servlet���󴴽�֮������ִ�У�����ִֻ��һ�Σ�����֮��
	 * ��Ӧ�õ�һ�α������ʱ�򣬵���init����������tomcat�Ĵ򿪶�����
	 */
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init");
		
		/*
		 * ��ȡ��ʼ������
		 */
		System.out.println(servletConfig.getInitParameter("p1"));
		System.out.println(servletConfig.getInitParameter("p2"));
		
		/*
		 * ��ȡ���г�ʼ������������
		 */
		Enumeration e = servletConfig.getInitParameterNames();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}

	/*
	 * �����������ڷ���
	 * ���ᱻ���ö��
	 * ÿ�δ����������ڵ����������
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("service");
	}
}
