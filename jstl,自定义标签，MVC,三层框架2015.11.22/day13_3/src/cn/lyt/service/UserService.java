package cn.lyt.service;

import cn.lyt.dao.UserDao;
import cn.lyt.domain.User;

public class UserService {
	// service ������dao��
	private UserDao userDao = new UserDao();
	
	// service�Ĳ�ѯ����Ҫʹ��dao����ɣ�
	public User find() {
		return userDao.find();
	}
}
