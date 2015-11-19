package cn.lyt.servlet;

import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class GServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String s = "hello outputStram";
//		byte[] bytes = s.getBytes();
//		response.getOutputStream().write(bytes);
		
		String path="H:coc.jpg";
		FileInputStream in = new FileInputStream(path);
		byte[] bytes = IOUtils.toByteArray(in);
		response.getOutputStream().write(bytes);
	}
}
