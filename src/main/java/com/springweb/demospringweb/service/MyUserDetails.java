package com.springweb.demospringweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springweb.demospringweb.model.Alien;
import com.springweb.demospringweb.model.Users;

import com.springweb.demospringweb.repo.AlienRepo;
import com.springweb.demospringweb.repo.UserRepo;

@Service
public class MyUserDetails implements UserDetailsService{

    @Autowired
    UserRepo repo;    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      Users a = repo.findByUsername(username);

      if(a == null)
      throw new UsernameNotFoundException("404 not found");

      return new UserPrinciple(a);
    }

}
