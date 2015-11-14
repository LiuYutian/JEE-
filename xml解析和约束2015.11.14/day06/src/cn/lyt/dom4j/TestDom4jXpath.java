package cn.lyt.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

import cn.lyt.utils.Dom4jUtils;

public class TestDom4jXpath {
	public static void main(String[] args) throws Exception {
//		selectName();
		selectSin();
	}
	
	// ʹ��xpathʵ�֣���ȡ��һ��p1�����name��ֵ
	public static void selectSin() throws Exception {
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		Node name = document.selectSingleNode("//p1[@id1='aaaa']/name");
		System.out.println(name.getText());
	}
	
	// ��ѯxml�����е�nameԪ��ֵ
	public static void selectName() throws Exception {
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		List<Node> names = document.selectNodes("//name");
		for(Node name : names) {
			System.out.println(name.getText());
		}
	}
}
