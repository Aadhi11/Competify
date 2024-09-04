package com.springweb.demospringweb.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springweb.demospringweb.model.Admins;

public interface AdminDetailsRepo extends JpaRepository<Admins,Integer> {

}
