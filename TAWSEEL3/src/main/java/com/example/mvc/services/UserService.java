package com.example.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.mvc.models.User;
import com.example.mvc.repositories.RoleRepository;
import com.example.mvc.repositories.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)     {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
	
	
    public void newUser(User user, String role) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(roleRepository.findByName(role));
		userRepository.save(user);
	}   
    
    // 3
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public List<User> getAllUsers(){
		return userRepository.findAll();
	}
    public User findUserById(Long userid) {
		Optional<User> user = userRepository.findById(userid);
		if (user.isPresent()) {
			return user.get();
		}
		else {
			return null;
		}
	}
    public User findByEmail(String email) {
    	User customer = userRepository.findByEmail(email);
		
			return customer;
		
	}
	public User findCustomerbyname(String user) {
		User customer = userRepository.findByUsername(user);
		
			return customer;
		
	}
	public User upgradeUser(User user) {
		user.setRoles(roleRepository.findByName("ROLE_ADMIN"));
		return userRepository.save(user);
	}
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
}
