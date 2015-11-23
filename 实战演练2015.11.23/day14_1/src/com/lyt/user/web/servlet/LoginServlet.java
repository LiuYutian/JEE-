package com.lyt.user.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;

import com.lyt.user.domain.User;
import com.lyt.user.service.UserException;
import com.lyt.user.service.UserService;

/**
 * UserServlet≤„
 * @author lyt
 *
 */
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // «Î«Û±‡¬Î
		response.setContentType("text/html;charset=utf-8"); // œÏ”¶±‡¬Î
		
		// “¿¿µUserService
		UserService userService = new UserService();
		
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		try{
			User user = userService.login(form);
			request.getSession().setAttribute("sessionUser", user);
			response.sendRedirect(request.getContextPath()+ "/user/welcome.jsp");
		}catch(UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", form);
			request.getRequestDispatcher("/user/login.jsp").forward(request, response);
		}
		
	} 
}
