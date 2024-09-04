package com.springweb.demospringweb.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

// import org.springframework.context.annotation.Scope;
// import org.springframework.stereotype.Component;



@Data
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String username;
    private String password;
    private String role ;

    @OneToOne
    @JoinColumn(name = "userdetails_id",referencedColumnName = "id")
    private Participants pd;

    @OneToOne
    @JoinColumn(name = "admindetails_id")
    private Admins ad;



}
