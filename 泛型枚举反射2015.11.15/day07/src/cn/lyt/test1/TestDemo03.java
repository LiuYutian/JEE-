package cn.lyt.test1;

import java.util.Arrays;

/**
 * 定义一个数组，实现指定位置上数组元素的交换
 * @author lyt
 *
 */
public class TestDemo03 {
	public static void main(String[] args) {
		// 创建一个数组， 实现11和13位置交换
		Integer[] arr1 = {10, 11, 12, 13, 14};
		System.out.println(Arrays.toString(arr1));
		swap1(arr1, 1, 3);
		System.out.println(Arrays.toString(arr1));

		// 交换dd， bb位置
		String[] arr2 = {"aa", "bb", "ccc", "dd", "ff"};
		System.out.println(Arrays.toString(arr2));
		swap1(arr2, 1, 3);
		System.out.println(Arrays.toString(arr2));
	}

	/* 	泛型方法
	*	使用泛型方法 需要定义一个类型 使用大写字母表示T：这个T表示任意的类型
	*	写在返回值之前void之前
	*	====表示定义了一个类型 这个类型就是T
	*	在下面就可以使用这个类型了T
	*/
	private static <T> void swap1(T[] arr, int a, int b) {
		T temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	/*private static void swap1(String[] arr2, int i, int j) {
		String temp = arr2[i];
		arr2[i] = arr2[j];
		arr2[j] = temp;
	}

	private static void swap1(int[] arr1, int i, int j) {
		int temp = arr1[i];
		arr1[i] = arr1[j];
		arr1[j] = temp;
	}*/
}
