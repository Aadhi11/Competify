package com.springweb.demospringweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springweb.demospringweb.model.Alien;





public interface AlienRepo extends JpaRepository<Alien,Integer>{
        Alien findByUsername(String username);
} 


