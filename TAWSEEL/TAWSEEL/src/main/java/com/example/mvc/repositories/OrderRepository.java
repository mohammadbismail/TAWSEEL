package com.example.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.models.Order;
import com.example.mvc.models.Restaurant;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long>{
	List<Order> findAll();

//	@Query(value="select * from orders As A join addresses AS B on B.id=A.Adress_id where B.city=?1 and A.food_type=?2 ", nativeQuery=true)
//	List<Order> getOrders(String cit, String foo);
}
