package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Job;


@Repository
public interface JobRepo extends JpaRepository<Job,Long>{

}
