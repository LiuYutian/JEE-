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
	
	// 使用jaxp遍历所有元素名称
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
	
	// 使用jaxp删除节点
	public static void deleteNode() throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(new File("src/cn/lyt/jaxp/person.xml"));
		NodeList p1s = document.getElementsByTagName("p1");
		// 获取父节点
		Node p1 = p1s.item(0);
		NodeList sexs = document.getElementsByTagName("sex");
		// 获取需删除节点
		Node sex = sexs.item(0);
		// 删除节点
		p1.removeChild(sex);
		// 会写到xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(); 
		// 包装dom
		DOMSource doms = new DOMSource(document);
		// 包装文件
		StreamResult sr = new StreamResult(new File("src/cn/lyt/jaxp/person.xml"));
		// 执行会写操作
		transformer.transform(doms, sr);
	}
	
	// 使用jaxp修改节点
	public static void changeSex() throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(new File("src/cn/lyt/jaxp/person.xml"));
		NodeList nodeList = document.getElementsByTagName("sex");
		Node sex1 = nodeList.item(0);
		sex1.setTextContent("男");
		// 会写到xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(); 
		// 包装dom
		DOMSource doms = new DOMSource(document);
		// 包装文件
		StreamResult sr = new StreamResult(new File("src/cn/lyt/jaxp/person.xml"));
		// 执行会写操作
		transformer.transform(doms, sr);
	} 
	
	// 使用jaxp添加节点
	public static void addSex() throws Exception{
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(new File("src/cn/lyt/jaxp/person.xml"));
		NodeList nodeList = document.getElementsByTagName("p1");
		Node p1 = nodeList.item(0);
		Element sex = document.createElement("sex");
		sex.setTextContent("女");
		p1.appendChild(sex);
		// 会写到xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer(); 
		// 包装dom
		DOMSource doms = new DOMSource(document);
		// 包装文件
		StreamResult sr = new StreamResult(new File("src/cn/lyt/jaxp/person.xml"));
		// 执行会写操作
		transformer.transform(doms, sr);
	}
	
	// 查询xml中第一个name元素的值
	public static void selectSin() throws Exception {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		Document document = builder.parse(new File("src/cn/lyt/jaxp/person.xml"));
		NodeList nodeList = document.getElementsByTagName("name");
		System.out.println(nodeList.item(0).getTextContent());
	}

	// 查询所有name元素的值
	private static void selectAll() throws Exception {
		// 查询所有name元素的值
		
		// 创建解析器工厂
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		// 实例化bulider
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		// 解析xml文件，返回document
		Document document = builder.parse(new File("src/cn/lyt/jaxp/person.xml"));
		// 得到name元素
		NodeList nodeList = document.getElementsByTagName("name");
		// 遍历输出
		for(int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			System.out.println(node.getTextContent());
		}
	}
}
