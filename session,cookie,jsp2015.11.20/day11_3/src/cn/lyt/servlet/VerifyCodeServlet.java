package cn.lyt.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lyt.image.VerifyCode;

public class VerifyCodeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1������ͼƬ
		 * 2������ͼƬ��session����
		 * 3����ͼƬ��Ӧ���ͻ���
		 */
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();
		request.getSession().setAttribute("session_vcode", vc.getText()); // ����ͼƬ�ϵ��ı�
		
		VerifyCode.output(image, response.getOutputStream());
	}
}
