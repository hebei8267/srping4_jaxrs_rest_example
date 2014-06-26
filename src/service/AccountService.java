package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import entity.User;

/**
 * 用户管理业务类.
 */
public class AccountService {
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	private static Logger logger = LoggerFactory.getLogger(AccountService.class);

	/**
	 * 按登录名查询用户.
	 */
	public User findUserByLoginName(String loginName) {
		User user = new User();

		user.setLoginName("bob");
		user.setPassword("bob");
		user.setName("test user");
		return user;
	}

}
