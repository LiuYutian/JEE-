package cn.lyt.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * simpleTagSupport��ʵ����simpleTag�ӿ�
 * 	���Ѿ������е�tomcat���ݵ����ݶ�����������
 * @author lyt
 *
 */
public class MyTag2 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().print("��hello һ��tag");
	}
}
