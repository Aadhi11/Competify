package com.springweb.demospringweb.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springweb.demospringweb.model.Events;

public interface EventRepo extends MongoRepository<Events,String> {

    @Query("{'admin_id' : ?0}")
    List<Events> findAllByAdmin_id(int id);

}
