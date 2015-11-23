package cn.lyt.service;

import cn.lyt.dao.UserDao;
import cn.lyt.domain.User;

public class UserService {
	// service 层依赖dao层
	private UserDao userDao = new UserDao();
	
	// service的查询，需要使用dao来完成！
	public User find() {
		return userDao.find();
	}
}
