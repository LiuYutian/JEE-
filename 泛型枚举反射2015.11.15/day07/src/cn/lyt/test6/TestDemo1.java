package cn.lyt.test6;

public class TestDemo1 {
	public static void main(String[] args) {
		add1(1, 2, 3, 4);
		add1(1, 2, 3, 4, 6);
		add1(1, 2, 3, 4, 6, 7);
	}
	
	/* 可变参方法
	 * 1、可变参书需要放在方法的参数列表中，不能单独定义
	 * 2、在方法的参数列表中只能有一个可变参数
	 * 3、方法的参数列表中的可变参数，必须放在参数最后
	 * 		add(int a, int...nums);
	 */
	public static void add1(int...nums) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		System.out.println(sum);
	}
	
//	// 实现两个数相加
//	public static void add1(int a, int b) {
//		int sum = a + b;
//		System.out.println(sum);
//	}
//	
//	// 实现三个数相加
//	public static void add1(int a, int b, int c) {
//		int sum = a + b + c;
//		System.out.println(sum);
//	}
//	
//	// 实现四个数相加
//	public static void add1(int a, int b, int c, int d) {
//		int sum = a + b + c + d;
//		System.out.println(sum);
//	}
}
