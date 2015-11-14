package cn.lyt.test;

import cn.lyt.service.StuService;
import cn.lyt.vo.Student;

public class TestStu {
	public static void main(String[] args) throws Exception {
//		testAdd();
//		testDel();
		testSelect();
	}
	
	public static void testAdd() throws Exception {
		Student student = new Student();
		student.setId("101");
		student.setName("xxx");
		student.setAge("23");
		StuService.addStu(student);
	}
	
	public static void testDel() throws Exception {
		StuService.delStu("100");
	}
	
	public static void testSelect() throws Exception {
		Student student = StuService.selectStu("101");
		System.out.println(student.getAge());
		System.out.println(student.getId());
		System.out.println(student.getName());
	}
}
