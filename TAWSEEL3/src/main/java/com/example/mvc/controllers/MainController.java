package com.example.mvc.controllers;

import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.models.User;
import com.example.mvc.services.UserService;
import com.example.mvc.validator.UserValidator;

@Controller
public class MainController {
	@Autowired
	UserService userServ;
//	private UserValidator userVal;
	
//	public MainController(UserValidator userVal) {
//		this.userVal = userVal;
//	}
	@PostMapping("/register")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model,
			HttpSession session,
			HttpServletRequest request
			) {
//		userVal.validate(user, result);
		String password = user.getPassword();
		if (result.hasErrors()) {
			return "registerPage.jsp";
		}
		if(userServ.getAllUsers().size()==0) {
			userServ.newUser(user, "ROLE_SUPER_ADMIN");
		}else {
			userServ.newUser(user, "ROLE_USER");
		}
		authWithHttpServletRequest(request, user.getEmail(), password);
		return "redirect:/";
	}

	public void authWithHttpServletRequest(HttpServletRequest request, String email, String password) {
	    try {
	        request.login(email, password);
	    } catch (ServletException e) {
	    	System.out.println("Error while login: " + e);
	    }
	}

	@RequestMapping("/login")
	public String login(
			@ModelAttribute("user") User user,
			@RequestParam(value="error", required=false) String error, 
			@RequestParam(value="logout", required=false) String logout, 
			Model model) {
		
		if(error!=null) {
			model.addAttribute("errorMessage","Invalid Credentials, Please try again.");
		}
		if(logout!=null) {
			model.addAttribute("logoutMessage","Logout Successful!");
		}
		
		return "registerPage.jsp";
	}
//	@RequestMapping("/admin")
//	public String adminPage(Principal principal, Model model) {
//		String email = principal.getName();
//		model.addAttribute("currentUser", userServ.findByEmail(email));
//		model.addAttribute("users", userServ.getAllUsers());
//		return "adminPage.jsp";
//	}
//	@RequestMapping("/admin/{id}")
//	public String makeAdmin(@PathVariable("id") Long id, Model model) {
//		
//		User user = userServ.findUserById(id);
//		userServ.upgradeUser(user);
//		
//		model.addAttribute("users", userServ.getAllUsers());
//		 
//		return "redirect:/admin";
//	}
	@RequestMapping(value = { "/", "/dashboard" })
	public String home(Principal principal, Model model) {
		// 1
		String email = principal.getName();
		User user = userServ.findByEmail(email);
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id, HttpSession session, Model model) {	
		User user = userServ.findUserById(id);
		userServ.deleteUser(user);
		
		model.addAttribute("users", userServ.getAllUsers());
		 
		return "redirect:/admin";
	}
}
