package cn.lyt.tag;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag3 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		Writer out = this.getJspContext().getOut();
		out.write("****************<br>");
		this.getJspBody().invoke(out); // ִ�б�ǩ�����ݣ��ѽ��д��ָ�������У���д��ҳ���ϡ�
		out.write("<br>****************");
	}
}
