package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepo;
@Service
public class UserService {

	@Autowired
	 private UserRepo userRepo;
	
	public List<User> findAll()
	{
		return userRepo.findAll();
	}
	
	
	public Optional<User> findById(Long id)
	{
		return userRepo.findById(id);
		
	}
	public User save(User user)
	{
		return userRepo.save(user);
		
	}
	
	public void deleteById(Long id)
	{
		userRepo.deleteById(id);
	}
	 
	 
}
