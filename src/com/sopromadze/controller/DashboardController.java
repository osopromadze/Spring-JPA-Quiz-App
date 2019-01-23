package com.sopromadze.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopromadze.entities.Role;
import com.sopromadze.entities.User;
import com.sopromadze.service.RoleService;
import com.sopromadze.service.UserService;
import com.sopromadze.utilities.UserToLogin;
import com.sopromadze.utilities.UserToUpdate;

@Controller
public class DashboardController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping(path = "/dashboard")
	public String showDashboard(HttpServletRequest request, Model model) { 
		UserToLogin userToLogin = getLoggedInUser(request);
		
		if (userToLogin == null) {
			return "redirect:/login";
		}
		
		model.addAttribute("loggedInUser", userToLogin);
		return "dashboard";
	}
	
	@GetMapping(path = "/users")
	public String showUsers(HttpServletRequest request, Model model) {
		UserToLogin userToLogin = getLoggedInUser(request);
		
		if (userToLogin == null) {
			return "redirect:/login";
		}
		
		if (userToLogin.getRoleId() != 1) {
			return "redirect:/dashboard";
		}
		
		List<User> allUsers = userService.getAllUsers();
		List<Role> allRoles = roleService.getAllRoles();
		
		model.addAttribute("allRoles", allRoles);
		model.addAttribute("allUsers", allUsers);
		model.addAttribute("loggedInUser", userToLogin);
		return "users";
	}
	
	@GetMapping(path = "/profile")
	public String showProfile(HttpServletRequest request, Model model) {
		UserToLogin loggedInUser = getLoggedInUser(request);
		
		if (loggedInUser == null) {
			return "redirect:/login";
		}
		
		User user = userService.getUserByUsername(loggedInUser.getUsername());
		
		if (user == null) {
			return "redirect:/dashboard";
		}
		
		UserToUpdate userToUpdate = new UserToUpdate();
		
		userToUpdate.setUsername(user.getUsername());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());
		
		model.addAttribute("user", user);
		model.addAttribute("userToUpdate", userToUpdate);
		model.addAttribute("loggedInUser", loggedInUser);
		return "profile";
	}
	
	@PostMapping(path = "/profile")
	public String updateProfile(@Valid @ModelAttribute UserToUpdate userToUpdate, BindingResult result, HttpServletRequest request, Model model) {
		UserToLogin userToLogin = getLoggedInUser(request);
		
		if (userToLogin == null) {
			return "redirect:/login";
		}
		
		model.addAttribute("loggedInUser", userToLogin);
		
		if (!userToUpdate.getPassword().trim().equals("")) {
			if (userToUpdate.getPassword().trim().length() >= 5 && userToUpdate.getPassword().trim().length() <= 20) {
				if (!userToUpdate.getPassword2().trim().equals(userToUpdate.getPassword().trim())) {
					userToUpdate.setPassword("");
					userToUpdate.setPassword2("");
					result.rejectValue("password2", "", "Passwords does not match");
				} 
			} else {
				userToUpdate.setPassword("");
				userToUpdate.setPassword2("");
				result.rejectValue("password", "", "Password must be minimum 5 and maximum 20 characters");
			}
		} 
		
		if (result.hasErrors()) {
			return null;
		}
		
		if (userService.updateUser(userToUpdate) == null) {
			return null;
		}
		
		return "redirect:/profile";
	}
	
	@PostMapping(path = "/change-role")
	public String changeRole(@RequestParam int roleId, @RequestParam String username, HttpServletRequest request) {
		UserToLogin userToLogin = getLoggedInUser(request);
		if (userToLogin == null) {
			return "redirect:/login";
		}
		
		if (userToLogin.getRoleId() != 1) {
			return "redirect:/dashboard";
		}
		
		userService.changeRole(roleId, username);
		
		return "redirect:/users";
	}
	
	
	private UserToLogin getLoggedInUser(HttpServletRequest request) {
		if (request.getSession().getAttribute("userToLogin") != null) {
			UserToLogin userToLogin = (UserToLogin) request.getSession().getAttribute("userToLogin");
			
			return userToLogin;
		}
		
		return null;
	}
}
