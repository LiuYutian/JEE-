package cn.lyt.servlet;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;


/*
 * 演示classLoader和class获取类路径资源
 */
public class Demo2 {
	@Test
	public void fun1() throws IOException {
		ClassLoader c1 = Demo2.class.getClassLoader();
		InputStream in = c1.getResourceAsStream("a.html");
		System.out.println(IOUtils.toString(in));
	}
	
	@Test 
	public void fun2 () throws IOException {
		Class c = Demo2.class;
		InputStream in = c.getResourceAsStream("/a.html");
//		InputStream in = c.getResourceAsStream("../../../a.html");
		System.out.println(IOUtils.toString(in));
	}
}
