package com.lyt.user.service;

import com.lyt.user.dao.UserDao;
import com.lyt.user.domain.User;

/**
 * User的业务逻辑层
 * @author lyt
 *
 */
public class UserService {
	private UserDao userDao = new UserDao();
	
	public void regist(User user) throws UserException {
		User _user = userDao.findByUsername(user.getUsername());
		if(_user != null) throw new UserException("用户名" + user.getUsername() + ", 已被注册过了!");
		
		userDao.add(user);
	}

	/**
	 * 登录功能
	 * @param form
	 * @return
	 * @throws UserException 
	 */
	public User login(User form) throws UserException {
		User user = userDao.findByUsername(form.getUsername());
		if(user == null) throw new UserException("用户名不存在!");
		
		if(!form.getPassword().equals(user.getPassword())) {
			throw new UserException("密码错误");
		}
		
		return user;
	}
}
