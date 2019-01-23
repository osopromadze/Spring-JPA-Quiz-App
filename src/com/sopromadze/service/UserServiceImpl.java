package com.sopromadze.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopromadze.dao.UserDao;
import com.sopromadze.entities.Role;
import com.sopromadze.entities.User;
import com.sopromadze.utilities.PasswordUtils;
import com.sopromadze.utilities.UserToLogin;
import com.sopromadze.utilities.UserToRegister;
import com.sopromadze.utilities.UserToUpdate;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleService roleService;
	
	@Override
	public void register(UserToRegister userToRegister) {
		User user = new User();
		
		user.setUsername(userToRegister.getUsername());
		user.setEmail(userToRegister.getEmail());
		user.setPassword(userToRegister.getPassword());
		
		String firstName = userToRegister.getFirstName();
		String lastName = userToRegister.getLastName();
		
		firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
		lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
		
		user.setFirstName(firstName);
		user.setLastName(lastName);
		
		Role role = null;
		
		if (getAllUsers().isEmpty()) {
			role = roleService.getRole(1);
		} else {
			role = roleService.getRole(3);
		}
		
		user.setRole(role);
		user.setActive((byte) 1);
		Date regtime = new Date();
		
		user.setRegtime(regtime);
		
		String salt = PasswordUtils.getSalt(30);
		String securePassword = PasswordUtils.generateSecurePassword(userToRegister.getPassword(), salt);
		
		user.setSalt(salt);
		user.setPassword(securePassword);
		
		if (userDao.getUserByUsername(user.getUsername()) == null) {
			userDao.register(user);
		}
	}
	
	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}
	
	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
		
	}
	
	@Override
	public User login(UserToLogin userToLogin) {
		User user = userDao.getUserByUsername(userToLogin.getUsername());
		
		if (user == null) {
			return null;
		}
		
		String salt = user.getSalt();
		
		boolean loggedIn = PasswordUtils.verifyUserPassword(userToLogin.getPassword(), user.getPassword(), salt);
		
		if (loggedIn) {
			return user;
		}
		
		return null;
	}
	
	@Override
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
	
	@Override
	public User updateUser(UserToUpdate userToUpdate) {
		User user = getUserByUsername(userToUpdate.getUsername());
		
		if (user == null) {
			return null;
		}
		
		user.setFirstName(userToUpdate.getFirstName());
		user.setLastName(userToUpdate.getLastName());
		
		if (!userToUpdate.getPassword().equals("")) {
			user.setPassword(userToUpdate.getPassword());
		}
		
		return userDao.updateUser(user);
	}
	
	@Override
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}
	
	@Override
	public User changeRole(int roleId, String username) {
		Role role = roleService.getRole(roleId);
		User user = userDao.getUserByUsername(username);
		
		if (role == null && user == null) {
			return null;
		}
		
		List<User> users = getAllUsers();
		int count = 0;
		
		for (User u : users) {
			if (u.getRole().getId() == 1) {
				count++;
			}
		}
		
		if ( count <= 1 && user.getRole().getId() == 1) {
			return null;
		}
		
		user.setRole(role);
		return userDao.updateUser(user);
	}
}
