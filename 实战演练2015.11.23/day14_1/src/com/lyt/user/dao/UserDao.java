package com.lyt.user.dao;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.lyt.user.domain.User;

/**
 * ������
 * @author lyt
 *
 */
public class UserDao {
	private String path = "H:/users.xml"; // ���������ļ�
	
	/**
	 * ���û�������
	 * @param username
	 * @return
	 */
	public User findByUsername(String username) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(path);
			Element ele = (Element)doc.selectSingleNode("//user[@username='" + username + "']");
			if(ele == null) return null;
			
			User user = new User();
			String attrUsername = ele.attributeValue("username"); // ��ȡ��Ԫ����Ϊusername����ֵ
			String attrpassword = ele.attributeValue("password"); // ��ȡ����
			user.setUsername(attrUsername);
			user.setPassword(attrpassword);
			
			return user;
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * ����û� 
	 * @param user
	 */
	public void add(User user) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(path);
			Element root = doc.getRootElement();
			// ͨ����Ԫ�أ�������Ԫ��
			Element userEle = root.addElement("user");
			userEle.addAttribute("username", user.getUsername());
			userEle.addAttribute("password", user.getPassword());
			
			/*
			 * �����ĵ�
			 */
			// ���������ʽ����
			OutputFormat format = new OutputFormat("\t", true);	// ʹ��\t���У��Ƿ��У���
			format.setTrimText(true); // ���ԭ�еĻ��У�����
			
			// ����xmlWriter
			XMLWriter writer = new XMLWriter(
					new OutputStreamWriter(
							new FileOutputStream(path),"utf-8"), format);
			writer.write(doc);
			writer.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
