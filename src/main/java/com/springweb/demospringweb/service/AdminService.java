package com.springweb.demospringweb.service;

import com.springweb.demospringweb.model.Users;

public interface AdminService {
    void registerAdmin(String username,String emailid,int phno,String password);
}
