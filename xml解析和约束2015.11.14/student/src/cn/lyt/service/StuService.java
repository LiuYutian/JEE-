package cn.lyt.service;

import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.lyt.vo.Student;

public class StuService {
	// 增加
	public static void addStu(Student student) throws Exception {
		// 创建解析器
		SAXReader saxReader = new SAXReader();
		// 得到document
		Document document = saxReader.read("src/student.xml");
		// 得到根节点
		Element root = document.getRootElement();
		// 在根节点上面添加stu
		Element stu = root.addElement("stu");
		// 在stu标签上面添加id name age属性
		Element id1 = stu.addElement("id");
		Element name1 = stu.addElement("name");
		Element age = stu.addElement("age");
		id1.setText(student.getId());
		name1.setText(student.getName());
		age.setText(student.getAge());
		// 回写xml
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/student.xml"), format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	// 删除
	public static void delStu(String id) throws Exception {
		// 创建解析器
		SAXReader saxReader = new SAXReader();
		// 得到document
		Document document = saxReader.read("src/student.xml");
		// 得到根节点
		Element root = document.getRootElement();
		List<Node> listId = root.selectNodes("//id");
		for(Node node : listId) {
			if(node.getText().equals(id)){
				Element stu = node.getParent();
				Element student = stu.getParent();
				student.remove(stu);
			}
		}
		
		// 回写
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/student.xml"));
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	// 查询
	public static Student selectStu(String id) throws Exception {
		// 创建解析器
		SAXReader saxReader = new SAXReader();
		Student student = new Student();
		// 得到document
		Document document = saxReader.read("src/student.xml");
		// 得到根节点
		Element root = document.getRootElement();
		List<Node> listId = root.selectNodes("//id");
		for(Node node : listId) {
			if(node.getText().equals(id)){
				Element stu = node.getParent();
				student.setName(stu.element("name").getText());
				student.setAge(stu.element("age").getText());
				student.setId(stu.element("id").getText());
			}
		}
		return student;
	}
}
