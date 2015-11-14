package cn.lyt.jaxp;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestJaxp {
	public static void main(String[] args) throws Exception {
//		selectAll();
//		selectSin();
//		addSex();
//		changeSex();
//		deleteNode();
		listElement();
	}
	
	// ʹ��jaxp��������Ԫ������
	public static void listElement() throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(new File("src/cn/lyt/jaxp/person.xml"));
		childNodes(document);
	}
	
	public static void childNodes(Node node) {
		if(node.getNodeType() == Node.ELEMENT_NODE){
			System.out.println(node.getNodeName());
		}
		NodeList nodeCilds = node.getChildNodes();
		for(int i = 0; i < nodeCilds.getLength(); i++) {
			Node nodeCild = nodeCilds.item(i);
			childNodes(nodeCild);
		}
	}
	
	// ʹ��jaxpɾ���ڵ�
	public static void deleteNode() throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(new File("src/cn/lyt/jaxp/person.xml"));
		NodeList p1s = document.getElementsByTagName("p1");
		// ��ȡ���ڵ�
		Node p1 = p1s.item(0);
		NodeList sexs = document.getElementsByTagName("sex");
		// ��ȡ��ɾ���ڵ�
		Node sex = sexs.item(0);
		// ɾ���ڵ�
		p1.removeChild(sex);
		// ��д��xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(); 
		// ��װdom
		DOMSource doms = new DOMSource(document);
		// ��װ�ļ�
		StreamResult sr = new StreamResult(new File("src/cn/lyt/jaxp/person.xml"));
		// ִ�л�д����
		transformer.transform(doms, sr);
	}
	
	// ʹ��jaxp�޸Ľڵ�
	public static void changeSex() throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(new File("src/cn/lyt/jaxp/person.xml"));
		NodeList nodeList = document.getElementsByTagName("sex");
		Node sex1 = nodeList.item(0);
		sex1.setTextContent("��");
		// ��д��xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(); 
		// ��װdom
		DOMSource doms = new DOMSource(document);
		// ��װ�ļ�
		StreamResult sr = new StreamResult(new File("src/cn/lyt/jaxp/person.xml"));
		// ִ�л�д����
		transformer.transform(doms, sr);
	} 
	
	// ʹ��jaxp��ӽڵ�
	public static void addSex() throws Exception{
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(new File("src/cn/lyt/jaxp/person.xml"));
		NodeList nodeList = document.getElementsByTagName("p1");
		Node p1 = nodeList.item(0);
		Element sex = document.createElement("sex");
		sex.setTextContent("Ů");
		p1.appendChild(sex);
		// ��д��xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(); 
		// ��װdom
		DOMSource doms = new DOMSource(document);
		// ��װ�ļ�
		StreamResult sr = new StreamResult(new File("src/cn/lyt/jaxp/person.xml"));
		// ִ�л�д����
		transformer.transform(doms, sr);
	}
	
	// ��ѯxml�е�һ��nameԪ�ص�ֵ
	public static void selectSin() throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(new File("src/cn/lyt/jaxp/person.xml"));
		NodeList nodeList = document.getElementsByTagName("name");
		System.out.println(nodeList.item(0).getTextContent());
	}

	// ��ѯ����nameԪ�ص�ֵ
	private static void selectAll() throws Exception {
		// ��ѯ����nameԪ�ص�ֵ
		
		// ��������������
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		// ʵ����bulider
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		// ����xml�ļ�������document
		Document document = builder.parse(new File("src/cn/lyt/jaxp/person.xml"));
		// �õ�nameԪ��
		NodeList nodeList = document.getElementsByTagName("name");
		// �������
		for(int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			System.out.println(node.getTextContent());
		}
	}
}
