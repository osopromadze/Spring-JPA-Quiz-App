package com.sopromadze.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sopromadze.service.UserService;
import com.sopromadze.utilities.UserToLogin;
import com.sopromadze.utilities.UserToRegister;

@Controller
@Validated
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/register")
	public String showRegister(Model model, HttpServletRequest request) {
		UserToLogin userToLogin = getLoggedInUser(request);
		if (userToLogin != null) {
			model.addAttribute("loggedInUser", userToLogin);
			return "redirect:/";
		}
		
		model.addAttribute("userToRegister", new UserToRegister());
		return "register";
	}
	
	@PostMapping(path = "/register")
	public String register(@Valid @ModelAttribute UserToRegister userToRegister, BindingResult result) {
		
		if (!userToRegister.getPassword2().equals(userToRegister.getPassword())) {
			result.rejectValue("password2", "", "Passwords does not match");
		}
		
		if (userService.getUserByUsername(userToRegister.getUsername()) != null) {
			result.rejectValue("username", "", "Username already exists");
		}
		
		if (userService.getUserByEmail(userToRegister.getEmail()) != null) {
			result.rejectValue("email", "", "Email already exists");
		}
		
		if (result.hasErrors()) {
			userToRegister.setPassword("");
			userToRegister.setPassword2("");
			return null;
		}
		
		userService.register(userToRegister);
		
		
		return "redirect:/login";
	}
	
	private UserToLogin getLoggedInUser(HttpServletRequest request) {
		if (request.getSession().getAttribute("userToLogin") != null) {
			UserToLogin userToLogin = (UserToLogin) request.getSession().getAttribute("userToLogin");
			
			return userToLogin;
		}
		
		return null;
	}
}
