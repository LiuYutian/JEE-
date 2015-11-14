package cn.lyt.utils;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jUtils {
	
	public static final String PATH = "src/cn/lyt/dom4j/p1.xml";
	
	// 返回document
	public static Document getDocument(String path) {
		try {
			// 创建解析器
			SAXReader reader = new SAXReader();
			// 得到document
			Document docunemt =	reader.read(path);
			return docunemt;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 回写xml的方法
	public static void xmlWriters(String path, Document document){
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			// 漂亮的格式
			OutputFormat outputFormat = OutputFormat.createPrettyPrint();
			
			XMLWriter xmlWriter = new XMLWriter(fileOutputStream, outputFormat);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
