package cn.lyt.dao;

import cn.lyt.domain.User;

public class UserDao {
	
	/**
	 * ��xml�е����ݲ�ѯ����֮�󣬷�װ��user�����У�Ȼ�󷵻�
	 * @return user
	 */
	public User find() {
		return new User("����", "123123");
	}
}
