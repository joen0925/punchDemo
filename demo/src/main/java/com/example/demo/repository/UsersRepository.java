package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Users;
import java.util.Optional;


@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>{
    Optional<Users> findByUserName(String userName);
} 