package cn.lyt.utils;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jUtils {
	
	public static final String PATH = "src/cn/lyt/dom4j/p1.xml";
	
	// ����document
	public static Document getDocument(String path) {
		try {
			// ����������
			SAXReader reader = new SAXReader();
			// �õ�document
			Document docunemt =	reader.read(path);
			return docunemt;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// ��дxml�ķ���
	public static void xmlWriters(String path, Document document){
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			// Ư���ĸ�ʽ
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			
			XMLWriter xmlWriter = new XMLWriter(fileOutputStream, outputFormat);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
