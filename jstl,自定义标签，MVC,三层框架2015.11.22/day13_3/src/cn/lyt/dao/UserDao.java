package cn.lyt.dao;

import cn.lyt.domain.User;

public class UserDao {
	
	/**
	 * 把xml中的数据查询出来之后，封装到user对象中，然后返回
	 * @return user
	 */
	public User find() {
		return new User("张三", "123123");
	}
}
