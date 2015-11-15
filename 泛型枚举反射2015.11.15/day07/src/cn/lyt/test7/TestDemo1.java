package cn.lyt.test7;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestDemo1 {
	public static void main(String[] args) throws Exception {
		Class clazz1 = Person.class;
		Class clazz2 = new Person().getClass();
		Class clazz3 = Class.forName("cn.lyt.test7.Person");
	}
	
	// 操作方法
	@Test
	public void test4() {
		try {
			Class c3 = Class.forName("cn.lyt.test7.Person");
			Method m1 = c3.getDeclaredMethod("setName", String.class);
			Person p = (Person) c3.newInstance();
			m1.invoke(p, "123");
			System.out.println(p.getName());
			
			// 使用无参方法。
			Method m2 = c3.getDeclaredMethod("getName", null);
			System.out.println((String)m2.invoke(p, null));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	// 操作name属性
	@Test
	public void test3() {
		// 得到Class
		try {
			Class c3 = Class.forName("cn.lyt.test7.Person");
			// Field fd = c3.getDeclaredFields();
			Field f1 = c3.getDeclaredField("name");
			// 如果是私有属性，则需要设置
			f1.setAccessible(true);
			// 得到person
			Person p1 = (Person)c3.newInstance();
			f1.set(p1, "lyt");
			// 相当于p.name
			System.out.println(f1.get(p1));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	// 操作有参数的构造方法
	@Test
	public void test2() throws Exception {
		// 得到Class
		Class c2 = Class.forName("cn.lyt.test7.Person");
		// 使用有参的构造方法
//		c2.getConstructors(); // 获取所有的构造方法
		// 传递是有参数的构造方法里面参数类型， 类型使用class形式传递
		Constructor cs = c2.getConstructor(String.class, String.class);
		Person p1 = (Person)cs.newInstance("李四", "100");
		System.out.println(p1.getId() + " " + p1.getName());
	}
	
	// 操作无参数的构造方法
	@Test
	public void test1() throws Exception {
		// 得到Class
		Class c1 = Class.forName("cn.lyt.test7.Person");
		// 得到Person类的实例
		Person p = (Person)c1.newInstance();
		// 设置值
		p.setName("张三");
		System.out.println(p.getName());
	}
}
