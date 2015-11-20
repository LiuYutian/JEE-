package cn.lyt.uuid;

import java.util.UUID;

import org.junit.Test;

import cn.lyt.commons.CommonsUtils;

public class UUIDTest {
	
	@Test
	public void fun1() {
		UUID uuid = UUID.randomUUID();
		String s = uuid.toString().replace("-", "").toUpperCase();
		System.out.println(s);
		
		System.out.println(CommonsUtils.uuid());
	}
}
