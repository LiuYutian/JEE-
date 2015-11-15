package cn.lyt.test;

public class TestDemo2 {
	public static void main(String[] args) {
		add();
//		如果出现下面错误，使用这条代码System.exit(0);
//		ERROR: JDWP Unable to get JNI 1.2 environment, jvm->GetEnv() return code = -2
//		JDWP exit error AGENT_ERROR_NO_JNI_ENV(183):  [../../../src/share/back/util.c:820]
	}
	
	// 1-100 sum
	public static void add() {
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			sum+=i;
		}
		System.out.println(sum);
	}
}
