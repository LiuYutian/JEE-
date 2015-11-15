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
 * �����ڼ����ϵ�ʹ��
 * @author lyt
 *
 */
public class TestDemo02 {
	// ������map�ϵ�ʹ��
	@Test
	public void testMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "333");
		// ���ֱ�����ʽ
		// 1����ȡ���е�key��ͨ��key�õ�value
		Set<String> keys = map.keySet();
		for(String key : keys) {
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		
		// 2���õ�key��value�Ĺ�ϵ
		Set<Entry<String, String>> sets1 = map.entrySet();
		for(Entry<String, String> ent : sets1){
			ent.getKey();
			ent.getValue();
			System.out.println(ent.getKey() + " : " + ent.getValue());
		}
	}
	
	// ������set�ϵ�ʹ��
	@Test
	public void testSet() {
		Set<String> set = new HashSet<String>();
		set.add("aaa");
		set.add("www");
		set.add("zzz");
		set.add("qqq");
		// ����set���ַ�ʽ
		// ��ǿfor
		for(String s2 : set){
			System.out.println(s2);
		}
		
		// ������
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	// ������list�ϵ�ʹ��
	@Test
	public void testList() {
		List<String> list = new ArrayList<String>();
		list.add(":aaa");
		list.add("bbb");
		list.add("ddd");
		// ����list�����м��ַ�ʽ ����
		// ��ͨforѭ��������������ǿfor
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("===========");
		
		// ��ǿfor
		for(String s1 : list) {
			System.out.println(s1);
		}
	
		System.out.println("===========");

		// ʹ�õ�����
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}	
}
