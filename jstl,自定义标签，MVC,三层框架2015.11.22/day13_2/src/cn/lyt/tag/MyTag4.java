package cn.lyt.tag;


import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag4 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().print("<h1>��ҳ���ǩ�µ����ݲ�����ʾ</h1>");
		throw new SkipPageException(); // �׳�����쳣�󣬱���ǩ��������ݽ�������
	}
}
