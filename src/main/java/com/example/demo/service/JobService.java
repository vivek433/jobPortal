package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Job;
import com.example.demo.entities.User;
import com.example.demo.repository.JobRepo;
@Service
public class JobService {

@Autowired	
private JobRepo jobRepo;



public List<Job> findAll()
{
	return jobRepo.findAll();
}


public Optional<Job> findById(Long id)
{
	return jobRepo.findById(id);
	
}
public Job save(Job job)
{
	return jobRepo.save(job);
	
}

public void deleteById(Long id)
{
	jobRepo.deleteById(id);
}
}
