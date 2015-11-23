package cn.lyt.domain;

/*
 * javaBean
 * ����Ϊ��Ա�ṩget/set��������ֻ�ṩһ��Ҳ�ǿ��Եģ�
 * ����Ҫ��Ĭ�Ϲ��������޲εģ�
 * һ����ھ���get/set�����ĳ�Ա������֮Ϊ����
 * 
 * ��ʵ����һ������û�ж��ڵĳ�Ա������ֻ��get/set����Ҳ�ǿ��Եġ�
 * 	��ʵ���Ե����ƾ���get/set����ȥ��get/set���ٰ�����ĸ��д�ˣ�
 */
public class Person {
	private String name;
	private int age;
	private String gender;
	private Boolean bool;
	
	public String getId() {
		return "234580";
	}
	
	public boolean isBool(){
		return bool;
	}
	
	public void setBool(boolean bool) {
		this.bool = bool;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender
				+ "]";
	}
	public Person(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public Person() {
		super();
	}
}
