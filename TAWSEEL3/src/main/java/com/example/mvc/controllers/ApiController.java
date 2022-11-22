package com.example.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc.models.Item;
import com.example.mvc.models.Restaurant;
import com.example.mvc.services.RestaurantService;
import com.example.mvc.services.UserService;

@RestController
public class ApiController {
	@Autowired
	private RestaurantService resServ;
	@Autowired
	UserService userServ;

	@GetMapping("/dashboard")
	public List<Restaurant> home(@RequestParam("city") String city, @RequestParam("food") String food, Model model) {
		if (city.equals("0") && food.equals("0")) {
//		  System.out.print(resServ.allRes());
			return resServ.allRes();
		} else if (city.equals("0")) {
			return resServ.filterByfoodType(food);
		} else if (food.equals("0")) {
			return resServ.filterByCity(city);
		} else {
			System.out.print(resServ.allRes());
			return resServ.filter(city, food);

		}
	}

	@GetMapping("/restaurant/{id}")
	public List<Item> res(@PathVariable("id") Long id, HttpSession sisson, Model model) {
		Restaurant restaurant = resServ.findRestaurant(id);

		return restaurant.getItems();

	}
//@GetMapping("/order/{id}")
//public Order order(@PathVariable("id") Long id,HttpSession sisson,Model model) {
//	User user=userServ.findUserById(id);
////	System.out.print(user.getOrder().get(customor.getOrder().size()-1));
////	Order order= user.getOrder().get(customor.getOrder().size()-1);
////	return order;
//			

//	@PostMapping("/makeOrder")
//	public String makeOrder(@RequestParam(""),@RequestParam("")) {
//		
//	}

}

//}
