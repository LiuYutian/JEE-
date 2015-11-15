package cn.lyt.test2;

import org.junit.Test;

public class TestEnum3 {
	// ֪��ö�ٵ��±꣬�õ�ö�ٶ��������
	@Test
	public void test3() {
		Color100[] objs = Color100.values();
		String name = objs[2].name();
		System.out.println(name);
	}
	
	// ֪��ö�ٵ����ƣ��õ�ö�ٵĶ�����±�
	@Test
	public void test2() {
		String name1 = "GREEN";
		// �õ�����
		Color100 c1 = Color100.valueOf(name1);
		// ö���±�
		int idx1 = c1.ordinal();
		System.out.println(idx1);
	}
	
	// ֪��ö�ٵĶ��󣬵õ�ö�����ƺ��±�
	@Test
	public void test1() {
		// �õ�ö�ٶ���
		Color100 c100 = Color100.RED;
		// ö�ٵ�����
		String name = c100.name();
		// ö�ٵ��±�
		int idx = c100.ordinal();
		System.out.println(name + 
				" " + idx);
	}
}

enum Color100 {
	RED, GREEN, YELLOW;	
}
