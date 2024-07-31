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

import com.example.demo.entities.Job;
import com.example.demo.service.JobService;

;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
	@Autowired
	private JobService service;
	
	
	@GetMapping
	public List<Job> getAllJobs()
	{
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable Long id)
	{
		Optional<Job> job=service.findById(id);
		if(job.isPresent())
		{
			return ResponseEntity.ok(job.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@PostMapping
	public Job createJob(@RequestBody Job job)
	{
		return service.save(job);
	}

	
	@PutMapping
	public ResponseEntity<Job> updateJob(@PathVariable Long id ,@RequestBody Job job)
	{
		Optional<Job>existingJob=service.findById(id);
		if(existingJob.isPresent())
		{job.setJobId(id);;
	
			return ResponseEntity.ok(service.save(job));
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteJob(@PathVariable Long id)
	{
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	

}
