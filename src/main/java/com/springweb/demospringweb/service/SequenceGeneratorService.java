package com.springweb.demospringweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.springweb.demospringweb.model.DbSequence;


@Service
public class SequenceGeneratorService {

    @Autowired
    private MongoOperations mongoOperations;

    public int getSequenceNumber(String sequencename){
        Query query = new Query(Criteria.where("id").is(sequencename));
        Update update = new Update().inc("seq", 1);
       // DbSequence counter = mongoOperations.findAndModify()
       return 0;
    }

}
