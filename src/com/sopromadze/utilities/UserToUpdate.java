package com.sopromadze.utilities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class UserToUpdate {
	
	@Length(min = 5, max = 20, message = "Username must be minimum 5 and maximum 20 characters")
	private String username;

	@Length(min = 5, max = 20, message = "Email must be minimum 5 and maximum 20 characters")
	@Email(message = "Invalid email format")
	private String email;

	@Length(min = 2, max = 20, message = "First name must be minimum 2 and maximum 20 characters")
	private String firstName;

	@Length(min = 2, max = 20, message = "Last name must be minimum 2 and maximum 20 characters")
	private String lastName;

	private String password;
	
	private String password2;
	
	private String avatarUrl;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	
	
}
