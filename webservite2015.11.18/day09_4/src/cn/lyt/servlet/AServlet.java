package cn.lyt.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.omg.CORBA_2_3.portable.OutputStream;

import com.sun.corba.se.impl.presentation.rmi.DynamicMethodMarshallerImpl.ReaderWriter;

public class AServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		ClassLoader cl = this.getClass().getClassLoader();
//		InputStream input = cl.getResourceAsStream("cn/lyt/servlet/a.txt");
		Class c = this.getClass();
		// 相对于class文件的位置
//		InputStream input = c.getResourceAsStream("../../../a.txt");
		// c.getResourceAsStream("/a.txt");
		InputStream input = c.getResourceAsStream("/../../index.jsp");
		String s = IOUtils.toString(input);
		System.out.println(s);
	}
}
