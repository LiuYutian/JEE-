package cn.lyt.jaxpsax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class TestSax {
	
	public static void main(String[] args) throws Exception {
		// 创建解析器工厂
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		// 创建解析器
		SAXParser saxParser = saxParserFactory.newSAXParser();
		saxParser.parse("src/cn/lyt/jaxpsax/p1.xml", new MyDefault2());
	}
}

// 实现获取所有的name元素的值
class MyDefault2 extends DefaultHandler {
	boolean flag = false;
	int index = 0;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if("name".equals(qName)) {
			flag = true;
			index++;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(flag && index == 1) {
			System.out.println(new String(ch, start, length));
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if("name".equals(qName)) {
			flag = false;
		}
	}
}

class MyDefault1 extends DefaultHandler {

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.print("<" + qName + ">");
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.print(new String(ch, start, length));
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.print("</" + qName + ">");
	}
}
