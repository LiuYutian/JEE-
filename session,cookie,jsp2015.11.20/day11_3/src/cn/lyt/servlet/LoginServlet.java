package cn.lyt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1����ȡ������
		 */
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(!"lyt".equalsIgnoreCase(username)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			Cookie cookie = new Cookie("uname", username);
			cookie.setMaxAge(60*60); // ��Ч��1Сʱ
			response.addCookie(cookie);
			response.sendRedirect("/day11_3/session2/succ1.jsp");
		} else { // ��¼ʧ��
			request.setAttribute("msg", "�û����������");
			RequestDispatcher qr = request.getRequestDispatcher("/session2/login.jsp");
			qr.forward(request, response);
		}
	}
}
