package cn.lyt.test4;

public class TestDemo2 {
	public static void main(String[] args) {
		doSomething(10);
	}
	
	/*
	 * 调用它的原因是如果调用Integer的话会有类型转换，而且jdk4是这个方法，
	 * 向下兼容原则，所有也是必然调用double。
	 */
	public static void doSomething(double m) {
		System.out.println("double......");
	}
	
	public static void doSomething(Integer a) {
		System.out.println("integer......");
	}
}
