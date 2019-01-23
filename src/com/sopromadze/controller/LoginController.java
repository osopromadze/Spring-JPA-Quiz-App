package com.sopromadze.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sopromadze.entities.User;
import com.sopromadze.service.UserService;
import com.sopromadze.utilities.UserToLogin;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@GetMapping(path = "/login")
	public String showLogin(Model model, HttpServletRequest request) {
		UserToLogin userToLogin = getLoggedInUser(request);
		if (userToLogin != null) {
			model.addAttribute("loggedInUser", userToLogin);
			return "redirect:/";
		}
		
		model.addAttribute("userToLogin", new UserToLogin());
		
		return "login";
	}
	
	@PostMapping(path = "/login")
	public String login(@Valid @ModelAttribute UserToLogin userToLogin, BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return null;
		}
		
		User user = userService.login(userToLogin);
		
		if (user != null) {
			userToLogin.setRoleId(user.getRole().getId());
			userToLogin.setPassword(user.getPassword());
			request.getSession().setAttribute("userToLogin", userToLogin);
			request.getSession().setMaxInactiveInterval(3600);
			return "redirect:/dashboard";
		}
		
		return "redirect:/login";
	}
	
	@GetMapping(path = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		
		return "redirect:/";
	}
	
	private UserToLogin getLoggedInUser(HttpServletRequest request) {
		if (request.getSession().getAttribute("userToLogin") != null) {
			UserToLogin userToLogin = (UserToLogin) request.getSession().getAttribute("userToLogin");
			
			return userToLogin;
		}
		
		return null;
	}
}
