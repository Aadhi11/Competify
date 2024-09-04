package com.springweb.demospringweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springweb.demospringweb.config.UserSecurityConfig;
import com.springweb.demospringweb.model.Admins;
import com.springweb.demospringweb.model.Alien;
import com.springweb.demospringweb.model.Participants;
import com.springweb.demospringweb.model.Users;
import com.springweb.demospringweb.repo.AdminDetailsRepo;
import com.springweb.demospringweb.repo.AlienRepo;
import com.springweb.demospringweb.repo.ParticipantsDetailsRepo;
import com.springweb.demospringweb.repo.UserRepo;

@Service
public class UserServiceImple implements UserService{

    @Autowired
    UserRepo repo;

    @Autowired
    ParticipantsDetailsRepo PdRepo;

    @Autowired
    AdminDetailsRepo AdRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(String username,String emailid,int phno,String password) {
        Users a = new Users();
        a.setPassword(passwordEncoder.encode(password));
        a.setRole("USER");
        a.setUsername(username);
        Participants pd = new Participants();
        pd.setEmailid(emailid);
        pd.setPhno(phno);
        System.out.println(a);
        System.out.println(pd);
       
        repo.save(a);
        a.setPd(pd);
        PdRepo.save(pd);
        
    }

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
        AdRepo.save(pd);
        
        
    }

    

}
