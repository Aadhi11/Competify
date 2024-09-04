package com.springweb.demospringweb.model;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Document
public class DbSequence {

    @Id
    private String id;
    private int seqNo;

}
