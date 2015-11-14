package cn.lyt.dom4j;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.lyt.utils.Dom4jUtils;

public class TestDom4j {
	public static void main(String[] args) throws Exception {
//		selectName();
//		selectSin();
//		selectSecond();
//		addSex();
//		addAgeBefore();
//		modifyAge();
//		delSchool();
		getValues();
	}
	
	// 获取p1属性id1的值
	public static void getValues() throws Exception {
		Document document = Dom4jUtils.getDocument("src/cn/lyt/dom4j/p1.xml");
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		System.out.println(p1.attributeValue("id1"));
	}
	
	// 删除第一个p1节点下面的<school></school>
	public static void delSchool() throws Exception {
		Document document = Dom4jUtils.getDocument("src/cn/lyt/dom4j/p1.xml");
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		Element school = p1.element("school");
		p1.remove(school);
		Dom4jUtils.xmlWriters("src/cn/lyt/dom4j/p1.xml", document);
	}
	
	// 修改第一个p1下面的age的值<age>30</age>
	public static void modifyAge() throws Exception {
		Document document = Dom4jUtils.getDocument("src/cn/lyt/dom4j/p1.xml");
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		Element age = p1.element("age");
		age.setText("30");
		Dom4jUtils.xmlWriters("src/cn/lyt/dom4j/p1.xml", document);
	}
	
	// 在特定位置添加元素	第一个p1下面的age标签前添加<school>ecit.edu.cn</school>
	public static void addAgeBefore() throws Exception {
		// 创建解析器
		//SAXReader saxReader = new SAXReader();
		// 得到document
		//Document document = saxReader.read("src/cn/lyt/dom4j/p1.xml");
		Document document = Dom4jUtils.getDocument("src/cn/lyt/dom4j/p1.xml");
		// 得到根节点
		Element root = document.getRootElement();
		// 得到p1
		Element p1 = root.element("p1");
		// 获取p1下的所有元素
		List<Element> p1s = p1.elements();
		// 创建元素
		Element school = DocumentHelper.createElement("school");
		school.setText("ecit.edu.cn");
		p1s.add(1, school);
		
		Dom4jUtils.xmlWriters("src/cn/lyt/dom4j/p1.xml", document);
		
//		XMLWriter xmlWriter = 
//				new XMLWriter(
//						new FileOutputStream("src/cn/lyt/dom4j/p1.xml"), OutputFormat.createPrettyPrint());
//																		// 漂亮的格式
//		xmlWriter.write(document);
//		xmlWriter.close();
	}
	
	// 在第一个p1标签的末尾添加一个元素<sex></sex>
	public static void addSex() throws Exception {
		// 创建解析器
		SAXReader saxReader = new SAXReader();
		// 得到document
		Document document = saxReader.read("src/cn/lyt/dom4j/p1.xml");
		// 得到根节点
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		// 添加标签sex
		Element sex1 = p1.addElement("sex");
		sex1.setText("男");
		
		// 回写xml
		XMLWriter xmlWriter = 
				new XMLWriter(
						new FileOutputStream("src/cn/lyt/dom4j/p1.xml"), OutputFormat.createPrettyPrint());
																		// 漂亮的格式
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	// 得到第二个name的值
	public static void selectSecond() throws Exception{
		// 创建解析器
		SAXReader saxReader = new SAXReader();
		// 得到document
		Document document = saxReader.read("src/cn/lyt/dom4j/p1.xml");
		// 得到根节点
		Element root = document.getRootElement();
		Element p1 = (Element) root.elements().get(1);
		Element name = p1.element("name");
		System.out.println(name.getText());
	}
	
	// 获取到第一个name的值
	public static void selectSin() throws Exception {
		// 创建解析器
		SAXReader saxReader = new SAXReader();
		// 得到document
		Document document = saxReader.read("src/cn/lyt/dom4j/p1.xml");
		// 得到根节点
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		Element name = p1.element("name");
		System.out.println(name.getText());
	}
	
	// 查询aml中所有name的值
	public static void selectName() throws Exception {
		// 创建解析器
		SAXReader saxReader = new SAXReader();
		// 得到document
		Document document = saxReader.read("src/cn/lyt/dom4j/p1.xml");
		// 得到根节点
		Element root = document.getRootElement();
		
		// 得到p1
		List<Element> list = root.elements("p1");
		//　遍历list
		for(Element element : list) {
			// element是每一个p1
			Element name1 = element.element("name");
			System.out.println(name1.getText());
		}
	}
}
