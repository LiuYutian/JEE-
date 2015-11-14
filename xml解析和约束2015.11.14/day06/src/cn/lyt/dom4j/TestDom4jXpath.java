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
	
	// 使用xpath实现，获取第一个p1下面的name的值
	public static void selectSin() throws Exception {
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		Node name = document.selectSingleNode("//p1[@id1='aaaa']/name");
		System.out.println(name.getText());
	}
	
	// 查询xml中所有的name元素值
	public static void selectName() throws Exception {
		Document document = Dom4jUtils.getDocument(Dom4jUtils.PATH);
		List<Node> names = document.selectNodes("//name");
		for(Node name : names) {
			System.out.println(name.getText());
		}
	}
}
