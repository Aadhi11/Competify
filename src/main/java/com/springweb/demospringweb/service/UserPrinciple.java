package com.springweb.demospringweb.service;

import java.beans.JavaBean;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.springweb.demospringweb.model.Alien;
import com.springweb.demospringweb.model.Participants;
import com.springweb.demospringweb.model.Users;


public class UserPrinciple implements UserDetails {

    Users a;

    public UserPrinciple(Users a){
        super();
        this.a = a;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return Collections.singleton(new SimpleGrantedAuthority(a.getRole()));
    }

    public int getId(){
        return a.getId();
    }

    public Participants getDetailId(){
            return a.getPd();
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
       return a.getPassword();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
       return a.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
       // throw new UnsupportedOperationException("Unimplemented method 'isAccountNonExpired'");
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }
    
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}
