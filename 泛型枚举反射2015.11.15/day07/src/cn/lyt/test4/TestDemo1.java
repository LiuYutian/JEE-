package cn.lyt.test4;

public class TestDemo1 {
	public static void main(String[] args) {
		// 自动装箱
		Integer i = 10;
		// 自动拆箱
		int m = i;
	}
	
	// 在jdk1.4里面实现拆装箱
	public void test1() {
		// 装
		Integer m = new Integer(10);
		// 拆
		int a = m.intValue();
	}
}
