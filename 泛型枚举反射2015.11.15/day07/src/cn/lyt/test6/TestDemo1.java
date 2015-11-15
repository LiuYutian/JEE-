package cn.lyt.test6;

public class TestDemo1 {
	public static void main(String[] args) {
		add1(1, 2, 3, 4);
		add1(1, 2, 3, 4, 6);
		add1(1, 2, 3, 4, 6, 7);
	}
	
	/* �ɱ�η���
	 * 1���ɱ������Ҫ���ڷ����Ĳ����б��У����ܵ�������
	 * 2���ڷ����Ĳ����б���ֻ����һ���ɱ����
	 * 3�������Ĳ����б��еĿɱ������������ڲ������
	 * 		add(int a, int...nums);
	 */
	public static void add1(int...nums) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		System.out.println(sum);
	}
	
//	// ʵ�����������
//	public static void add1(int a, int b) {
//		int sum = a + b;
//		System.out.println(sum);
//	}
//	
//	// ʵ�����������
//	public static void add1(int a, int b, int c) {
//		int sum = a + b + c;
//		System.out.println(sum);
//	}
//	
//	// ʵ���ĸ������
//	public static void add1(int a, int b, int c, int d) {
//		int sum = a + b + c + d;
//		System.out.println(sum);
//	}
}
