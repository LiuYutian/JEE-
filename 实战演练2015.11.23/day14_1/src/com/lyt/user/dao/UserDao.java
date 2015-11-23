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
 * 数据类
 * @author lyt
 *
 */
public class UserDao {
	private String path = "H:/users.xml"; // 依赖数据文件
	
	/**
	 * 按用户名查找
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
			String attrUsername = ele.attributeValue("username"); // 获取该元素名为username属性值
			String attrpassword = ele.attributeValue("password"); // 获取密码
			user.setUsername(attrUsername);
			user.setPassword(attrpassword);
			
			return user;
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 添加用户 
	 * @param user
	 */
	public void add(User user) {
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(path);
			Element root = doc.getRootElement();
			// 通过根元素，创建新元素
			Element userEle = root.addElement("user");
			userEle.addAttribute("username", user.getUsername());
			userEle.addAttribute("password", user.getPassword());
			
			/*
			 * 保存文档
			 */
			// 创建输出格式化器
			OutputFormat format = new OutputFormat("\t", true);	// 使用\t换行，是否换行，是
			format.setTrimText(true); // 清空原有的换行，缩进
			
			// 创建xmlWriter
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
