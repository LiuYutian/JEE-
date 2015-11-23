package com.lyt.user.service;

import com.lyt.user.dao.UserDao;
import com.lyt.user.domain.User;

/**
 * User��ҵ���߼���
 * @author lyt
 *
 */
public class UserService {
	private UserDao userDao = new UserDao();
	
	public void regist(User user) throws UserException {
		User _user = userDao.findByUsername(user.getUsername());
		if(_user != null) throw new UserException("�û���" + user.getUsername() + ", �ѱ�ע�����!");
		
		userDao.add(user);
	}

	/**
	 * ��¼����
	 * @param form
	 * @return
	 * @throws UserException 
	 */
	public User login(User form) throws UserException {
		User user = userDao.findByUsername(form.getUsername());
		if(user == null) throw new UserException("�û���������!");
		
		if(!form.getPassword().equals(user.getPassword())) {
			throw new UserException("�������");
		}
		
		return user;
	}
}
