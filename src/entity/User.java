package entity;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import org.springside.modules.utils.Collections3;

import com.google.common.collect.Lists;

/**
 * 用户.
 * 
 */
public class User {
	private String loginName;
	private String password;
	private String name;

	private List<Role> roleList = Lists.newArrayList(); // 有序的关联对象集合

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String getRoleNames() {
		return Collections3.extractToString(roleList, "name", ", ");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}