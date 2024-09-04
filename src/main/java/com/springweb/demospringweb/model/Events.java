package com.springweb.demospringweb.model;

import java.util.List;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document
public class Events {

    // @Transient
    // private static final String SEQUENCE_NAME = "user_sequence";
    @Field(targetType = FieldType.OBJECT_ID)
    private String id;
    private int admin_id;
    private String title;
    private String desc;
    List<String> required;

}
