package cn.lyt.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

/**
 * 泛型在集合上的使用
 * @author lyt
 *
 */
public class TestDemo02 {
	// 泛型在map上的使用
	@Test
	public void testMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		// 两种遍历方式
		// 1、获取所有的key，通过key得到value
		Set<String> keys = map.keySet();
		for(String key : keys) {
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		
		// 2、得到key和value的关系
		Set<Entry<String, String>> sets1 = map.entrySet();
		for(Entry<String, String> ent : sets1){
			ent.getKey();
			ent.getValue();
			System.out.println(ent.getKey() + " : " + ent.getValue());
		}
	}
	
	// 泛型在set上的使用
	@Test
	public void testSet() {
		Set<String> set = new HashSet<String>();
		set.add("aaa");
		set.add("www");
		set.add("zzz");
		set.add("qqq");
		// 遍历set两种方式
		// 增强for
		for(String s2 : set){
			System.out.println(s2);
		}
		
		// 迭代器
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	// 泛型在list上的使用
	@Test
	public void testList() {
		List<String> list = new ArrayList<String>();
		list.add(":aaa");
		list.add("bbb");
		list.add("ddd");
		// 遍历list集合有几种方式 三种
		// 普通for循环，迭代器，增强for
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("===========");
		
		// 增强for
		for(String s1 : list) {
			System.out.println(s1);
		}
	
		System.out.println("===========");

		// 使用迭代器
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}	
}
