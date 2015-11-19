package cn.lyt.servlet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

import org.junit.Test;

/**
 * url����
 * @author lyt
 *
 */
public class Demo {
	/*
	 * [-27, -68, -96, -28, -72, -119] + 256 ��ʮ������ת������url����
	 */
	@Test
	public void fun1() throws UnsupportedEncodingException {
		String name = "����";
		byte[] bytes = name.getBytes("utf-8");
		System.out.println(Arrays.toString(bytes));
		
		String s = URLEncoder.encode(name, "UTF-8");
		System.out.println(s);
		String news = URLDecoder.decode(s, "utf-8");
		System.out.println(news);
	}
}
