package com.springweb.demospringweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

// import org.springframework.context.annotation.Scope;
// import org.springframework.stereotype.Component;



@Data
@Entity
public class Alien {

    @Id
    private int id;
    private String username;
    private String tech;
    private String password;

}
