package service;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import entity.Role;
import entity.User;

public class ShiroDbRealm extends AuthorizingRealm {
	protected AccountService accountService;

	/**
	 * 认证回调函数,登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = accountService.findUserByLoginName(token.getUsername());
		System.out.println("111111111111111111111");
		if (user != null) {
			return new SimpleAuthenticationInfo(user.getLoginName(), user.getPassword(), user.getName());
		} else {
			return null;
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 获取当前登录的用户名
		String loginName = (String) super.getAvailablePrincipal(principals);
		User user = accountService.findUserByLoginName(loginName);
		System.out.println("222222222222222222");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

		info.addStringPermission("/user/getUserInfo");

		for (Role role : user.getRoleList()) {
			// 基于Role的权限信息
			info.addRole(role.getName());
			// 基于Permission的权限信息
			info.addStringPermissions(role.getPermissionList());
		}
		return info;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

}
