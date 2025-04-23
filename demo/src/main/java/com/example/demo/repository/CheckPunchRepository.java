package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CheckPunch;

@Repository
public interface CheckPunchRepository extends JpaRepository<CheckPunch,Integer> {
    List<CheckPunch> findAll();	
	List<CheckPunch> findByName(String name);
}
