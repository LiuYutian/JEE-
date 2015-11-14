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
	// ����
	public static void addStu(Student student) throws Exception {
		// ����������
		SAXReader saxReader = new SAXReader();
		// �õ�document
		Document document = saxReader.read("src/student.xml");
		// �õ����ڵ�
		Element root = document.getRootElement();
		// �ڸ��ڵ��������stu
		Element stu = root.addElement("stu");
		// ��stu��ǩ�������id name age����
		Element id1 = stu.addElement("id");
		Element name1 = stu.addElement("name");
		Element age = stu.addElement("age");
		id1.setText(student.getId());
		name1.setText(student.getName());
		age.setText(student.getAge());
		// ��дxml
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/student.xml"), format);
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	// ɾ��
	public static void delStu(String id) throws Exception {
		// ����������
		SAXReader saxReader = new SAXReader();
		// �õ�document
		Document document = saxReader.read("src/student.xml");
		// �õ����ڵ�
		Element root = document.getRootElement();
		List<Node> listId = root.selectNodes("//id");
		for(Node node : listId) {
			if(node.getText().equals(id)){
				Element stu = node.getParent();
				Element student = stu.getParent();
				student.remove(stu);
			}
		}
		
		// ��д
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/student.xml"));
		xmlWriter.write(document);
		xmlWriter.close();
	}
	
	// ��ѯ
	public static Student selectStu(String id) throws Exception {
		// ����������
		SAXReader saxReader = new SAXReader();
		Student student = new Student();
		// �õ�document
		Document document = saxReader.read("src/student.xml");
		// �õ����ڵ�
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
