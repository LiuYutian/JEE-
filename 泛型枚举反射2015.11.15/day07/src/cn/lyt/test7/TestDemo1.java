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
	
	// ��������
	@Test
	public void test4() {
		try {
			Class c3 = Class.forName("cn.lyt.test7.Person");
			Method m1 = c3.getDeclaredMethod("setName", String.class);
			Person p = (Person) c3.newInstance();
			m1.invoke(p, "123");
			System.out.println(p.getName());
			
			// ʹ���޲η�����
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
	
	// ����name����
	@Test
	public void test3() {
		// �õ�Class
		try {
			Class c3 = Class.forName("cn.lyt.test7.Person");
			// Field fd = c3.getDeclaredFields();
			Field f1 = c3.getDeclaredField("name");
			// �����˽�����ԣ�����Ҫ����
			f1.setAccessible(true);
			// �õ�person
			Person p1 = (Person)c3.newInstance();
			f1.set(p1, "lyt");
			// �൱��p.name
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
	
	// �����в����Ĺ��췽��
	@Test
	public void test2() throws Exception {
		// �õ�Class
		Class c2 = Class.forName("cn.lyt.test7.Person");
		// ʹ���вεĹ��췽��
//		c2.getConstructors(); // ��ȡ���еĹ��췽��
		// �������в����Ĺ��췽������������ͣ� ����ʹ��class��ʽ����
		Constructor cs = c2.getConstructor(String.class, String.class);
		Person p1 = (Person)cs.newInstance("����", "100");
		System.out.println(p1.getId() + " " + p1.getName());
	}
	
	// �����޲����Ĺ��췽��
	@Test
	public void test1() throws Exception {
		// �õ�Class
		Class c1 = Class.forName("cn.lyt.test7.Person");
		// �õ�Person���ʵ��
		Person p = (Person)c1.newInstance();
		// ����ֵ
		p.setName("����");
		System.out.println(p.getName());
	}
}
