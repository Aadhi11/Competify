package com.springweb.demospringweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springweb.demospringweb.model.Admins;
import com.springweb.demospringweb.model.Participants;
import com.springweb.demospringweb.model.Users;
import com.springweb.demospringweb.repo.AdminDetailsRepo;
import com.springweb.demospringweb.repo.ParticipantsDetailsRepo;
import com.springweb.demospringweb.repo.UserRepo;


public class AdminServiceImple implements AdminService{

    @Autowired
    UserRepo repo;

    @Autowired
    AdminDetailsRepo PdRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerAdmin(String username,String emailid,int phno,String password) {
        Users a = new Users();
        a.setPassword(passwordEncoder.encode(password));
        a.setRole("ADMIN");
        a.setUsername(username);
        Admins pd = new Admins();
        pd.setEmailid(emailid);
        pd.setPhno(phno);
        System.out.println(a);
        System.out.println(pd);
       
        repo.save(a);
        a.setAd(pd);
        PdRepo.save(pd);
        
        
    }

}
