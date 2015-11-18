package cn.lyt.servelt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ͳ�Ʒ����� 
 */
public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// ��ȡservletContext����
		ServletContext app = this.getServletContext();
		Integer count = (Integer) app.getAttribute("count");
		if(count == null) {
			app.setAttribute("count", 1);
		} else {
			app.setAttribute("count", 1 + count);
		}
		
		PrintWriter pw = response.getWriter();
		pw.print("<h1>" + count + "</h1>");
	}
}
