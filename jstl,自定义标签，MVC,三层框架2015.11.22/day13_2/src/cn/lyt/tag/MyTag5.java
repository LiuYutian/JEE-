package cn.lyt.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * �����Եı�ǩ
 * @author lyt
 *
 */
public class MyTag5 extends SimpleTagSupport {
	private boolean test;
	
	/*
	 * �����������tomcat�����ã�������doTag֮ǰ
	 */
	public void setTest(boolean test) {
		this.test = test;
	}
	
	
	@Override
	public void doTag() throws JspException, IOException {
		if(test) {
			this.getJspBody().invoke(null); // ������ݵ������Ϊnull����ʾʹ�õ�ǰҳ���out
		}
	}
}
