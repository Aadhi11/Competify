package com.springweb.demospringweb.service;

import java.util.List;

import com.springweb.demospringweb.model.Events;
import com.springweb.demospringweb.model.Participants;
import com.springweb.demospringweb.model.Registers;

public interface EventService {

    void createEvent(Events e,int id);
    List<Events> showevents(int id);
    void registerEvent(String details,String event_id,int user_id,Participants p);
    List<Registers> showParticipants(String id);

}
