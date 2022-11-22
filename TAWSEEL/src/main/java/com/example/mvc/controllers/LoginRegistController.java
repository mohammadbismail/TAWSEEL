package com.example.mvc.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mvc.models.Address;
import com.example.mvc.models.Customer;
import com.example.mvc.models.Item;
import com.example.mvc.models.Order;
import com.example.mvc.models.Restaurant;
import com.example.mvc.services.CustomerService;
import com.example.mvc.services.RestaurantService;
import com.example.mvc.validator.UserValidator;

@Controller
public class LoginRegistController {
	@Autowired
	CustomerService customerServ;
	@Autowired
	UserValidator userValidator;
	@Autowired
	private RestaurantService resServ;
	
	
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
		  userValidator.validate(customer, result);
	        if (result.hasErrors()) {
	            return "registerPage.jsp";
	        }
	        
	        customerServ.saveWithUserRole(customer);
//	        customerServ.saveUserWithAdminRole(customer);
	       
	       
	        return "redirect:/";
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
	 @GetMapping("/")
	    public String home(Principal principal, Model model,@RequestParam(value="FoodType",defaultValue ="0",required=false) String food,@RequestParam(value="City",defaultValue = "0",required=false) String city ) {
	        // 1
		 String username="";
		 if(principal!=null) {
	         username = principal.getName();}
	        if(username!="") {
	        model.addAttribute("currentUser", customerServ.findCustomerbyname(username));}
//	        System.out.print("4");
//	        System.out.print(resServ.allRes());
	        if((city.equals("0")&& food.equals("0"))) {
//	  		  System.out.print(resServ.allRes());
	  		  model.addAttribute("Res",resServ.allRes());
	  		  
	  		
	  	  }
	  	  else if(city.equals("0")) {
	  		  model.addAttribute("Res",resServ.filterByfoodType(food)); 
	  	  }
	  	  else if(food.equals("0")) {
	  		  model.addAttribute("Res",resServ.filterByCity(city)) ;
	  	  }
	  	 
	  	  else {
	  		  
	  		  model.addAttribute("Res",resServ.filter(city, food)) ;
	  		  
	  	  }
	        return "dashboard.jsp";
	    }
	
	  @GetMapping("/restaurant/{id}")
	  public String res(@PathVariable("id") Long id,HttpSession sisson,Model model,Principal principal) {
	  	Restaurant restaurant=resServ.findRestaurant(id);
	  	 String username = principal.getName();
	        model.addAttribute("currentUser", customerServ.findCustomerbyname(username));
	  	
	  	model.addAttribute("restaurant",restaurant);
	  	return "menu2.jsp";
}
	  @GetMapping("/neworder/{idI}")
	  public String order(@PathVariable("idI")Long idI,Principal principal,@RequestParam("idR")Long idR,HttpSession session,Model model) { 
		
		
		int sum=0;
		
		 String username = principal.getName();
		 Item item=resServ.findItem(idI);
		 if(session.getAttribute("order")==null) {
			 Order order =new Order();
			List<Item> i=new ArrayList<Item>();
			i.add(item);
			order.setItem(i);
			 session.setAttribute("order", order);
			 
			 for(int j=0;j< order.getItem().size();j++) {
				 sum+=order.getItem().get(j).getPrice();
			 }
			 session.setAttribute("sum", sum);
			 }
		 else {
		 Order order=(Order)session.getAttribute("order");
		 Customer customer= customerServ.findCustomerbyname(username);
		
		 
			 
			 order.setCustomer(customer);
			 order.getItem().add(item);
			 
			 for(int j=0;j< order.getItem().size();j++) {
				 sum+=order.getItem().get(j).getPrice();
				
			 }
			session.setAttribute("sum", sum);
			 }
		 
			
			 
			
			 
			 return "redirect:/restaurant/"+idR;
	  }
	  @GetMapping("/order")
	  public String order(HttpSession session,Model model,@ModelAttribute("address")Address address,Principal principal) {
		 Order order=(Order) session.getAttribute("order");
				 
		  order =resServ.creatrOrder(order);
		  model.addAttribute("order", order);
		  String username="";
		  if(principal!=null) {
		         username = principal.getName();}
		        if(username!="") {
		        model.addAttribute("currentUser", customerServ.findCustomerbyname(username));}
		  
		  return "show.jsp";
	  }
	  @PostMapping("/addAdress")
	  public String adress(@Valid @ModelAttribute("address")Address address,BindingResult result,HttpSession session,Model model,Principal principal) {
		  Order order=(Order) session.getAttribute("order");
		  String username="";
		  if(principal!=null) {
		         username = principal.getName();}
		        if(username!="") {
		        model.addAttribute("currentUser", customerServ.findCustomerbyname(username));}
		  if (result.hasErrors()) {
			  
				 
			 
			  model.addAttribute("order", order);
			 
			 
			  return "show.jsp";
		  }
		  else {
			  
			  
			  
			  resServ.createAddress(address);
			  order.setAddress(address);
			  order.setCustomer(customerServ.findCustomerbyname(username));
			  order =resServ.creatrOrder(order);
			  return "redirect:/order";
			  
		  }
	  }
	  @RequestMapping("/admin")
	    public String adminPage(Principal principal, Model model) {
	        String username = principal.getName();
	        model.addAttribute("currentUser", customerServ.findCustomerbyname(username));
	        model.addAttribute("allOrders", resServ.getAllOrders());
			model.addAttribute("allRest",resServ.allRes());
	        return "adminPage.jsp";
	    }
	  @DeleteMapping("/orderDelete/{orderid}")
		  public String cancelOrder(@PathVariable("orderid") Long orderid) {
		  resServ.cancelOrder(orderid);
		  // change to admin page
		  return "redirect:/admin";
	  }
		@DeleteMapping("/resDelete/{resid}")
		public String deleteRes(@PathVariable("resid") Long resid) {
			resServ.deleteRest(resid);
			// change to admin page
			return "redirect:/admin";
		}
	  }
	  
