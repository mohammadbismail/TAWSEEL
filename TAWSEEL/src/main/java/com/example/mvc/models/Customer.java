package com.example.mvc.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Name can't be null")
	@Size(min=6,max=100,message="Name has to be 6 characters minimum")
	private String username;
	
	@NotNull(message="email can't be empty")
	private String email;
	
	@Min(value=10,message="please enter a valid number")
    private Integer number;
	
	@NotNull(message="password can't be null")
	@Size(min=8,max=100,message="password must be at least 8 characters !")
    private String password;
	
	@Transient
	@NotNull(message="password can't be null")
	@Size(min=8,max=100,message="password must be at least 8 characters !")
    private String confirm;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-DD','HH:mm")
	private Date createdAt;

	@DateTimeFormat(pattern = "yyyy-MM-DD','HH:mm")
	private Date updatedAt;
	
	public Customer() {
 }
	
	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	@PrePersist
	public void setCreatedAt() {
		this.createdAt = new Date();
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	@PreUpdate
	public void setUpdatedAt() {
		this.updatedAt = new Date();
	}
	
	
}
