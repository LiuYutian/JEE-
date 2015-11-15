package cn.lyt.test5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestDemo1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		// ÔöÇ¿for
		for(String s : list) {
			System.out.println(s);
		}
		System.out.println("------------");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
