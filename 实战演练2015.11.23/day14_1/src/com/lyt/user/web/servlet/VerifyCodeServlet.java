package com.lyt.user.web.servlet;


import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.vcode.utils.VerifyCode;

public class VerifyCodeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1. 鍒涘缓楠岃瘉鐮佺被
		 */
		VerifyCode vc = new VerifyCode();
		/*
		 * 2. 寰楀埌楠岃瘉鐮佸浘鐗�
		 */
		BufferedImage image = vc.getImage();
		/*
		 * 3. 鎶婂浘鐗囦笂鐨勬枃鏈繚瀛樺埌session涓�
		 */
		request.getSession().setAttribute("session_vcode", vc.getText());
		/*
		 * 4. 鎶婂浘鐗囧搷搴旂粰瀹㈡埛绔�
		 */
		VerifyCode.output(image, response.getOutputStream());
	}
}
