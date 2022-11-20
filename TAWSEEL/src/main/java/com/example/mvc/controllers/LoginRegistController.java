package com.example.mvc.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mvc.models.Customer;
import com.example.mvc.models.CustomerLogin;
import com.example.mvc.services.CustomerService;

@Controller
public class LoginRegistController {
	@Autowired
	CustomerService customerServ;
	
	// Render - Register Page
	@GetMapping("/registration")
	public String registerPage(HttpSession session,Model model,@ModelAttribute("customer") Customer customer) {
		
		
		return "registerPage.jsp";
	}
	 @GetMapping("/login")
	    public String login( @ModelAttribute("customer") Customer customer,HttpSession session) {
		
	        return "registerPage.jsp";
	    }
	  @PostMapping("/registration")
	    public String registration(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model, HttpSession session) {
	        if (result.hasErrors()) {
	            return "registerPage.jsp";
	        }
	        customerServ.saveWithUserRole(customer);
	        return "redirect:/login";
	    }
	// Register 
//	@PostMapping("/register")
//	public String registerUser(@Valid @ModelAttribute("newCustomer") Customer customer, BindingResult result, Model model,
//			HttpSession session) {
//
//		// go to registration process in services
//		customerServ.register(customer, result);
//
//		if (result.hasErrors()) {
//			// if there are errors in filling registration form
//			// keep the filled data for registration object
//			// again give new login user object to fill
//			model.addAttribute("newLogin", new CustomerLogin());
//			return "registerPage.jsp";
//		} else {
//			session.setAttribute("customer_id", customer.getId());
//			session.setAttribute("logged_in", true);
//			return "redirect:/";
//		}
//	}
	// Login
//	@PostMapping("/login")
//	public String loginUser(@Valid @ModelAttribute("newLogin") CustomerLogin customerLogin, BindingResult result, Model model,
//			HttpSession session) {
//		// go to login process
//		customerServ.login(customerLogin, result);
//		if (result.hasErrors()) {
//			model.addAttribute("newCustomer", new Customer());
//			return "registerPage.jsp";
//		} else {
//			Customer registeredCustomer = customerServ.findCustomerByEmail(customerLogin.getEmail());
//			session.setAttribute("customer_id", registeredCustomer.getId());
//			session.setAttribute("logged_in", true);
//			return "redirect:/";
//		}
//	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/register";
	}
	 @RequestMapping(value = {"/", "/home"})
	    public String home(Principal principal, Model model) {
	        // 1
	        String username = principal.getName();
	        model.addAttribute("currentUser", customerServ.findCustomerbyname(username));
	        return "dashboard.jsp";
	    }
}
