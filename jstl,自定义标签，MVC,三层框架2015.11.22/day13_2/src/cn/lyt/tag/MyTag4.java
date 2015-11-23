package cn.lyt.tag;


import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag4 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().print("<h1>此页面标签下的内容不会显示</h1>");
		throw new SkipPageException(); // 抛出这个异常后，本标签后面的内容将看不到
	}
}
