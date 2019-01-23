package com.sopromadze.dao;

import java.util.List;

import com.sopromadze.entities.User;

public interface UserDao {

	User getUserByUsername(String username);

	void register(User user);

	List<User> getAllUsers();

	User login(String username, String password);

	User getUserByEmail(String email);

	User updateUser(User user);

}
