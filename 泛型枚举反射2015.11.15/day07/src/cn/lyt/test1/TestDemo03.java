package cn.lyt.test1;

import java.util.Arrays;

/**
 * ����һ�����飬ʵ��ָ��λ��������Ԫ�صĽ���
 * @author lyt
 *
 */
public class TestDemo03 {
	public static void main(String[] args) {
		// ����һ�����飬 ʵ��11��13λ�ý���
		Integer[] arr1 = {10, 11, 12, 13, 14};
		System.out.println(Arrays.toString(arr1));
		swap1(arr1, 1, 3);
		System.out.println(Arrays.toString(arr1));

		// ����dd�� bbλ��
		String[] arr2 = {"aa", "bb", "ccc", "dd", "ff"};
		System.out.println(Arrays.toString(arr2));
		swap1(arr2, 1, 3);
		System.out.println(Arrays.toString(arr2));
	}

	/* 	���ͷ���
	*	ʹ�÷��ͷ��� ��Ҫ����һ������ ʹ�ô�д��ĸ��ʾT�����T��ʾ���������
	*	д�ڷ���ֵ֮ǰvoid֮ǰ
	*	====��ʾ������һ������ ������;���T
	*	������Ϳ���ʹ�����������T
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
