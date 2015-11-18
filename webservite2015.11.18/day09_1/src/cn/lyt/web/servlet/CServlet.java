package cn.lyt.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CServlet extends BServlet {
	public void init() {
		System.out.println("(*@¦Ï@*) ÍÛ¡«~~~~~~");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		String value = super.getInitParameter("p1"); 
	}
}
