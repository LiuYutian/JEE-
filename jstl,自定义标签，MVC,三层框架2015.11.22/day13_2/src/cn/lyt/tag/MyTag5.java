package cn.lyt.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 有属性的标签
 * @author lyt
 *
 */
public class MyTag5 extends SimpleTagSupport {
	private boolean test;
	
	/*
	 * 这个方法会由tomcat来调用，并且在doTag之前
	 */
	public void setTest(boolean test) {
		this.test = test;
	}
	
	
	@Override
	public void doTag() throws JspException, IOException {
		if(test) {
			this.getJspBody().invoke(null); // 如果传递的输出流为null，表示使用当前页面的out
		}
	}
}
