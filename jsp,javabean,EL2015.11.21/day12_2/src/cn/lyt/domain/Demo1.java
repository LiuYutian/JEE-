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
		
		BeanUtils.setProperty(bean, "name", "张三");
		BeanUtils.setProperty(bean, "age", "23");
//		BeanUtils.setProperty(bean, "gender", "男");
		BeanUtils.setProperty(bean, "xxx", "XXX");
		
		String age = BeanUtils.getProperty(bean, "age");
		System.out.println(age);
		
		System.out.println(bean.toString());
	}
	
	/*
	 * 把map中的属性直接封装到一个bean中
	 * 
	 * Map:{"username":"zhangsan", "password":"123"}
	 * 我们要把map中的数据封装到Javabean中，要求map的kay和pean的属性名称相同
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
		 * 可以将表单获得的数据直接map的方式，放入javaBean
		 */
		
		User user = CommonUtils.toBean(map, User.class);
		System.out.println(user.toString());
	}
}
 