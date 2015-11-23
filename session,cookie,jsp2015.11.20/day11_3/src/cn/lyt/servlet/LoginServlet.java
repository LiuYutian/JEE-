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
		
		// 获取session中的数据
		String sessionCode = (String)request.getSession().getAttribute("session_vcode");
		// 获取用户输入的参数
		String paramCode  = request.getParameter("verifyCode");
		
		// 验证验证码是否正确
		if(!paramCode.equalsIgnoreCase(sessionCode)) {
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/session2/login.jsp").forward(request, response);
			return ;
		}
		
		/*
		 * 1、获取表单数据
		 */
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(!"lyt".equalsIgnoreCase(username)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			Cookie cookie = new Cookie("uname", username);
			cookie.setMaxAge(60*60); // 有效期1小时
			response.addCookie(cookie);
			response.sendRedirect("/day11_3/session2/succ1.jsp");
		} else { // 登录失败
			request.setAttribute("msg", "用户名密码错误");
			RequestDispatcher qr = request.getRequestDispatcher("/session2/login.jsp");
			qr.forward(request, response);
		}
	}
}
