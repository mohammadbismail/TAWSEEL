package com.example.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.models.Restaurant;
import com.example.mvc.repositories.RestaurantRepository;


@Service
public class RestaurantService {
@Autowired 
private RestaurantRepository restaurantRepo;
public List<Restaurant> allRes() {
	return restaurantRepo.findAll();
}
public Restaurant findRestaurant(Long id) {
	return restaurantRepo.findById(id).get();
}
public List<Restaurant> filterByfoodType(String str) {
	return restaurantRepo.findByfoodType(str);
}
public List<Restaurant> filterByCity(String str) {
	return restaurantRepo.filterbycity(str);
}
public List<Restaurant> filter(String ciy,String fo){
	return restaurantRepo.filter(ciy, fo);
}
public void deleteRest(Long resid) {
	restaurantRepo.deleteById(resid);
}

}
