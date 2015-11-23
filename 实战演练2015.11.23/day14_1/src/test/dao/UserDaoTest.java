package test.dao;

import org.junit.Test;

import com.lyt.user.dao.UserDao;
import com.lyt.user.domain.User;

/**
 * UserDao的测试类
 * @author lyt
 *
 */
public class UserDaoTest {
	@Test
	public void testFindByUsername() {
		UserDao userDao = new UserDao();
		User user = userDao.findByUsername("李wu");
		System.out.println(user);
	}
	
	@Test
	public void testAdd() {
		UserDao userDao = new UserDao();
		User user = new User();
		user.setUsername("李wu");
		user.setPassword("lisi");
		userDao.add(user);
	}
}
