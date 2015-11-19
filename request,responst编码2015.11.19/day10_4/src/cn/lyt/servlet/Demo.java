package cn.lyt.servlet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

import org.junit.Test;

/**
 * url编码
 * @author lyt
 *
 */
public class Demo {
	/*
	 * [-27, -68, -96, -28, -72, -119] + 256 按十六进制转换就是url编码
	 */
	@Test
	public void fun1() throws UnsupportedEncodingException {
		String name = "张三";
		byte[] bytes = name.getBytes("utf-8");
		System.out.println(Arrays.toString(bytes));
		
		String s = URLEncoder.encode(name, "UTF-8");
		System.out.println(s);
		String news = URLDecoder.decode(s, "utf-8");
		System.out.println(news);
	}
}
