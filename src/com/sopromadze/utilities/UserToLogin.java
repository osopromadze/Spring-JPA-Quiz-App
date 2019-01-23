package com.sopromadze.utilities;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class UserToLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Username can not be empty")
	private String username;
	
	@NotEmpty(message = "Password can not be empty")
	private String password;
	
	private int roleId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
}
