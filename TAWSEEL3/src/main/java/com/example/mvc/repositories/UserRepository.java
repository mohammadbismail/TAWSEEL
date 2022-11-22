package com.example.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.mvc.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	List<User> findAll();
	User findByEmail(String email);
	User findByUsername(String user);
}

