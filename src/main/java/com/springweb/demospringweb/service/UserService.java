package com.springweb.demospringweb.service;

import com.springweb.demospringweb.model.Alien;
import com.springweb.demospringweb.model.Users;

public interface UserService {

    void registerUser(String username,String emailid,int phno,String password);

    void registerAdmin(String username,String emailid,int phno,String password);

}
