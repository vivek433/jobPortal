package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping
	public List<User> getAllUsers()
	{
		return service.findAll();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id)
	{
		Optional<User> user=service.findById(id);
		if(user.isPresent())
		{
			return ResponseEntity.ok(user.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping
	public User createUser(@RequestBody User user)
	{
		return service.save(user);
	}

	
	@PutMapping
	public ResponseEntity<User> updateUser(@PathVariable Long id ,@RequestBody User user)
	{
		Optional<User>existingUser=service.findById(id);
		if(existingUser.isPresent())
		{user.setUserId(id);;
	
			return ResponseEntity.ok(service.save(user));
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id)
	{
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
