package service;

import entity.User;

/**
 * 用户管理业务类.
 */
public class AccountService {

	/**
	 * 按登录名查询用户.
	 */
	public User findUserByLoginName(String loginName) {
		User user = new User();

		user.setLoginName("bob");
		user.setPassword("bobbob");
		user.setName("test user");
		return user;
	}

}
