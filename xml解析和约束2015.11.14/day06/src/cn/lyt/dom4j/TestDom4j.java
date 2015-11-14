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
	
	// ��ȡp1����id1��ֵ
	public static void getValues() throws Exception {
		Document document = Dom4jUtils.getDocument("src/cn/lyt/dom4j/p1.xml");
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		System.out.println(p1.attributeValue("id1"));
	}
	
	// ɾ����һ��p1�ڵ������<school></school>
	public static void delSchool() throws Exception {
		Document document = Dom4jUtils.getDocument("src/cn/lyt/dom4j/p1.xml");
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		Element school = p1.element("school");
		p1.remove(school);
		Dom4jUtils.xmlWriters("src/cn/lyt/dom4j/p1.xml", document);
	}
	
	// �޸ĵ�һ��p1�����age��ֵ<age>30</age>
	public static void modifyAge() throws Exception {
		Document document = Dom4jUtils.getDocument("src/cn/lyt/dom4j/p1.xml");
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		Element age = p1.element("age");
		age.setText("30");
		Dom4jUtils.xmlWriters("src/cn/lyt/dom4j/p1.xml", document);
	}
	
	// ���ض�λ�����Ԫ��	��һ��p1�����age��ǩǰ���<school>ecit.edu.cn</school>
	public static void addAgeBefore() throws Exception {
		// ����������
		//SAXReader saxReader = new SAXReader();
		// �õ�document
		//Document document = saxReader.read("src/cn/lyt/dom4j/p1.xml");
		Document document = Dom4jUtils.getDocument("src/cn/lyt/dom4j/p1.xml");
		// �õ����ڵ�
		Element root = document.getRootElement();
		// �õ�p1
		Element p1 = root.element("p1");
		// ��ȡp1�µ�����Ԫ��
		List<Element> p1s = p1.elements();
		// ����Ԫ��
		Element school = DocumentHelper.createElement("school");
		school.setText("ecit.edu.cn");
		p1s.add(1, school);
		
		Dom4jUtils.xmlWriters("src/cn/lyt/dom4j/p1.xml", document);
		
//		XMLWriter xmlWriter = 
//				new XMLWriter(
//						new FileOutputStream("src/cn/lyt/dom4j/p1.xml"), OutputFormat.createPrettyPrint());
//																		// Ư���ĸ�ʽ
//		xmlWriter.write(document);
//		xmlWriter.close();
	}
	
	// �ڵ�һ��p1��ǩ��ĩβ���һ��Ԫ��<sex></sex>
	public static void addSex() throws Exception {
		// ����������
		SAXReader saxReader = new SAXReader();
		// �õ�document
		Document document = saxReader.read("src/cn/lyt/dom4j/p1.xml");
		// �õ����ڵ�
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		// ��ӱ�ǩsex
		Element sex1 = p1.addElement("sex");
		sex1.setText("��");
		
		// ��дxml
		XMLWriter xmlWriter = 
				new XMLWriter(
						new FileOutputStream("src/cn/lyt/dom4j/p1.xml"), OutputFormat.createPrettyPrint());
																		// Ư���ĸ�ʽ
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	// �õ��ڶ���name��ֵ
	public static void selectSecond() throws Exception{
		// ����������
		SAXReader saxReader = new SAXReader();
		// �õ�document
		Document document = saxReader.read("src/cn/lyt/dom4j/p1.xml");
		// �õ����ڵ�
		Element root = document.getRootElement();
		Element p1 = (Element) root.elements().get(1);
		Element name = p1.element("name");
		System.out.println(name.getText());
	}
	
	// ��ȡ����һ��name��ֵ
	public static void selectSin() throws Exception {
		// ����������
		SAXReader saxReader = new SAXReader();
		// �õ�document
		Document document = saxReader.read("src/cn/lyt/dom4j/p1.xml");
		// �õ����ڵ�
		Element root = document.getRootElement();
		Element p1 = root.element("p1");
		Element name = p1.element("name");
		System.out.println(name.getText());
	}
	
	// ��ѯaml������name��ֵ
	public static void selectName() throws Exception {
		// ����������
		SAXReader saxReader = new SAXReader();
		// �õ�document
		Document document = saxReader.read("src/cn/lyt/dom4j/p1.xml");
		// �õ����ڵ�
		Element root = document.getRootElement();
		
		// �õ�p1
		List<Element> list = root.elements("p1");
		//������list
		for(Element element : list) {
			// element��ÿһ��p1
			Element name1 = element.element("name");
			System.out.println(name1.getText());
		}
	}
}
