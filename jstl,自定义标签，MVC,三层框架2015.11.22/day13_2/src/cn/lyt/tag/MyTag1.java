package cn.lyt.tag;


import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

/**
 * �Զ����ǩ 1
 * @author lyt
 *
 */
public class MyTag1 implements SimpleTag{
	private PageContext pageContext;
	private JspFragment body;
	
	/**
	 * ���е�setXxx()����������doTag()����֮ǰ��tomcat����
	 * ����doTage()�оͿ���ʹ��tomcat���ݹ����Ķ����ˡ�
	 */
	
	@Override
	public void doTag() throws JspException, IOException {
		pageContext.getOut().print("hello Tag!");
	}

	@Override
	public JspTag getParent() {
		return null;
	}

	@Override
	public void setJspContext(JspContext context) {
		this.pageContext = (PageContext) context;
	}

	@Override
	public void setJspBody(JspFragment body) {
		this.body = body;
	}

	@Override
	public void setParent(JspTag parent) {}
}
