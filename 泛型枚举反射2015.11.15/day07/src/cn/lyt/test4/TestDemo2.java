package cn.lyt.test4;

public class TestDemo2 {
	public static void main(String[] args) {
		doSomething(10);
	}
	
	/*
	 * ��������ԭ�����������Integer�Ļ���������ת��������jdk4�����������
	 * ���¼���ԭ������Ҳ�Ǳ�Ȼ����double��
	 */
	public static void doSomething(double m) {
		System.out.println("double......");
	}
	
	public static void doSomething(Integer a) {
		System.out.println("integer......");
	}
}
