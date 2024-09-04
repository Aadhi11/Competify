package com.springweb.demospringweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springweb.demospringweb.model.Alien;
import com.springweb.demospringweb.model.Users;


public interface UserRepo extends JpaRepository<Users,Integer>{
        Users findByUsername(String username);
} 


