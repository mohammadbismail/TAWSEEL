package com.example.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc.models.Order;
import com.example.mvc.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepo;
	public List<Order> getAllOrders(){
		return orderRepo.findAll();
	}
	public void cancelOrder(Long orderid) {
		orderRepo.deleteById(orderid);
	}
}
