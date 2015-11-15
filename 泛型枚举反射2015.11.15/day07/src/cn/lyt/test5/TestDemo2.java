package cn.lyt.test5;

import java.util.Arrays;

/**
 * 实现一个泛型方法，接受任意类型的数组，点到数组中所有元素
 * @author lyt
 *
 */
public class TestDemo2 {
	public static void main(String[] args) {
		Integer[] arr1 = {10, 12, 13, 14, 15};
		reverses(arr1);
		System.out.println(Arrays.toString(arr1));

		String[] arr2 = {"aaa", "bbb", "ccc", "ddd"};
		reverses(arr2);
		System.out.println(Arrays.toString(arr2));
}
	
	public static <T> void reverses(T[] arr1) {
		for(int i = 0; i < arr1.length/2; i++) {
			T temp = arr1[i];
			arr1[i] = arr1[arr1.length-i-1];
			arr1[arr1.length-i-1] = temp;
		}
	}
}
