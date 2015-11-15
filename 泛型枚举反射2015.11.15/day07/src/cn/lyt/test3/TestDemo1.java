package cn.lyt.test3;

/**
 * ÑÝÊ¾¾²Ì¬µ¼Èë
 * @author lyt
 *
 */
import static java.lang.System.out;
import static java.util.Arrays.sort; 

import java.util.Arrays;

public class TestDemo1 {
	public static void main(String[] args) {
		out.println("hello");
		int[] arr1 = {10, 2, 45, 123, 23};
		sort(arr1);
		System.out.println(Arrays.toString(arr1));
	}
}
