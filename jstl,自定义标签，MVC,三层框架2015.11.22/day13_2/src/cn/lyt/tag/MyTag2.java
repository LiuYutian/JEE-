package cn.lyt.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * simpleTagSupport它实现了simpleTag接口
 * 	它已经把所有的tomcat传递的数据都保存起来了
 * @author lyt
 *
 */
public class MyTag2 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().print("在hello 一次tag");
	}
}
