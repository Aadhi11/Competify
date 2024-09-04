package com.springweb.demospringweb.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springweb.demospringweb.model.Registers;

public interface RegisterRepo extends MongoRepository<Registers,String>{

    @Query("{'event_id' : ?0}")
    List<Registers> findAllByEvent_id(String id);

}
