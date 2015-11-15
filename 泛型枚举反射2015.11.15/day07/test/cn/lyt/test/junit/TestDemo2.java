package cn.lyt.test.junit;

import junit.framework.Assert;

import org.junit.Test;

public class TestDemo2 {
	
	@Test
	public void test01() {
		int a = 3; 
		int b = 4;
		int sum = a + b;
		
		// 使用断言
//		Assert.assertEquals("期望值", "实际值");
		Assert.assertEquals(7, sum);
	}
}
