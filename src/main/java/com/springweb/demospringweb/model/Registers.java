package com.springweb.demospringweb.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document
public class Registers {

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private int user_id;
    private String event_id;
    private Map<String,String> details;
    
}

