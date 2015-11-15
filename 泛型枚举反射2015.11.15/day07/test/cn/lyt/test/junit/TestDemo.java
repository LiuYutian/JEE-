package cn.lyt.test.junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TestDemo {
	// ≤‚ ‘∑Ω∑®
	@Test
	public void testAdd1() {
		TestJunit junit = new TestJunit();
		junit.testAdd(2, 3);
//		int m = 10/0;
	}
	
	@Ignore
	public void test1() {
		TestJunit junit = new TestJunit();
		junit.test1();
	}
	
	@Before
	public void test2(){
		TestJunit junit = new TestJunit();
		junit.test2();
	}
	
	@After 
	public void test3() {
		TestJunit junit = new TestJunit();
		junit.test3();
	}
}
