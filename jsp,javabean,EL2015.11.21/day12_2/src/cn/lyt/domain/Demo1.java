package cn.lyt.domain;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import org.apache.commons.beanutils.BeanUtils;

import cn.lyt.Utils.CommonUtils;

public class Demo1 {
	@Test
	public void fun1() throws Exception {
		String className = "cn.lyt.domain.Person";
		Class clazz = Class.forName(className);
		Object bean = clazz.newInstance();
		
		BeanUtils.setProperty(bean, "name", "����");
		BeanUtils.setProperty(bean, "age", "23");
//		BeanUtils.setProperty(bean, "gender", "��");
		BeanUtils.setProperty(bean, "xxx", "XXX");
		
		String age = BeanUtils.getProperty(bean, "age");
		System.out.println(age);
		
		System.out.println(bean.toString());
	}
	
	/*
	 * ��map�е�����ֱ�ӷ�װ��һ��bean��
	 * 
	 * Map:{"username":"zhangsan", "password":"123"}
	 * ����Ҫ��map�е����ݷ�װ��Javabean�У�Ҫ��map��kay��pean������������ͬ
	 */
	@Test
	public void fun2() throws IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "zhangsan");
		map.put("password", "123");
		
		Class clazz = Class.forName("cn.lyt.domain.User");
		Object bean = clazz.newInstance();
		BeanUtils.populate(bean, map);
		
		System.out.println(bean.toString());
	}
	
	@Test
	public void fun3() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "zhangsan");
		map.put("password", "123");
		
		/*
		 * request.getParameterMap();
		 * ���Խ�����õ�����ֱ��map�ķ�ʽ������javaBean
		 */
		
		User user = CommonUtils.toBean(map, User.class);
		System.out.println(user.toString());
	}
}
 