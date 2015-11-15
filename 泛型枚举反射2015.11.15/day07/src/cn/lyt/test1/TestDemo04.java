package cn.lyt.test1;

public class TestDemo04<T> {
	// 在类里面就可以使用T类型
	T aa;
	public void test11(T bb) {}
	
	// 写一个静态方法， 在类上面定义的泛型，不能再静态方法里面使用
	public static <A> void test12(A cc) {}
}
