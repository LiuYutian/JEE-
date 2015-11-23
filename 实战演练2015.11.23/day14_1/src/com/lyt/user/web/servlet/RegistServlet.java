package com.lyt.user.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.awt.RepaintArea;

import cn.itcast.commons.CommonUtils;

import com.lyt.user.domain.User;
import com.lyt.user.service.UserException;
import com.lyt.user.service.UserService;

public class RegistServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8"); // �������
		response.setContentType("text/html;charset=utf-8"); // ��Ӧ����

		// ����UserService
		UserService userService = new UserService();
		
		User form = CommonUtils.toBean(request.getParameterMap(), User.class);
		
		/*
		 * ��������񣨱�У�飩
		 * 1. ����һ��Map������װ�����еı�������Ϣ
		 *   ��У������У����ʧ�ܣ���map��Ӵ�����Ϣ������keyΪ���ֶ�����
		 * 2. У��֮�󣬲鿴map�����Ƿ����0���������0��˵���д�����Ϣ�������д���
		 *   > ����map��request�У�����form��request�У�ת����regist.jsp
		 * 
		 * 3. ���mapΪ�գ�˵��û�д�����Ϣ������ִ�У�
		 */
		
		// ����װ�����д�����Ϣ
		Map<String,String> errors = new HashMap<String,String>();
		
		// ���û�������У��
		String username = form.getUsername();//��ȡ����username
		if(username == null || username.trim().isEmpty()) {
			errors.put("username", "�û�������Ϊ�գ�");
		} else if(username.length() < 3 || username.length() > 15) {
			errors.put("username", "�û������ȱ�����3~15֮�䣡");
		}
		
		// ���������У��
		String password = form.getPassword();
		if(password == null || password.trim().isEmpty()) {
			errors.put("password", "���벻��Ϊ�գ�");
		} else if(password.length() < 3 || password.length() > 15) {
			errors.put("password", "���볤�ȱ�����3~15֮�䣡");
		}
		
		
		// ����֤�����У��
		String sessionVerifyCode = (String) request.getSession().getAttribute("session_vcode");
		String verifyCode = form.getVerifyCode();
		if(verifyCode == null || verifyCode.trim().isEmpty()) {
			errors.put("verifyCode", "��֤�벻��Ϊ�գ�");
		} else if(verifyCode.length() != 4) {
			errors.put("verifyCode", "��֤�볤�ȱ���Ϊ4��");
		} else if(!verifyCode.equalsIgnoreCase(sessionVerifyCode)) {
			errors.put("verifyCode", "��֤�����");
		}
		
		/*
		 * �ж�map�Ƿ�Ϊ�գ���Ϊ�գ�˵�����ڴ���
		 */
		if(errors != null && errors.size() > 0) {
			/*
			 * 1. ����errors��request��
			 * 2. ����form��request��Ϊ�˻���
			 * 3. ת����regist.jsp
			 */
			request.setAttribute("errors", errors);
			request.setAttribute("user", form);
			request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
			return;
		}

		
		try {
			userService.regist(form);
			response.getWriter().print("<h1>ע��ɹ�!</h1><a href='"+ 
			request.getContextPath()+ 
			"/user/login.jsp" +"'>��������¼</a>");
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			// �����ڱ��л���
			request.setAttribute("user", form);
			
			request.getRequestDispatcher("/user/regist.jsp").forward(request, response);
		}
	}
}
