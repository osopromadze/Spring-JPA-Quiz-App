package com.sopromadze.service;

import java.util.List;

import com.sopromadze.entities.User;
import com.sopromadze.utilities.UserToLogin;
import com.sopromadze.utilities.UserToRegister;
import com.sopromadze.utilities.UserToUpdate;

public interface UserService {

	List<User> getAllUsers();

	User login(UserToLogin userToLogin);

	User getUserByUsername(String username);

	void register(UserToRegister userToRegister);

	User getUserByEmail(String email);

	User updateUser(UserToUpdate userToUpdate);

	User changeRole(int roleId, String username);

	User updateUser(User user);

}
