package com.springweb.demospringweb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springweb.demospringweb.model.Events;
import com.springweb.demospringweb.model.Participants;
import com.springweb.demospringweb.model.Registers;
import com.springweb.demospringweb.repo.EventRepo;
import com.springweb.demospringweb.repo.ParticipantsDetailsRepo;
import com.springweb.demospringweb.repo.RegisterRepo;


@Service
public class EventServiceImple implements EventService {

    @Autowired
    EventRepo repo;


    @Autowired
    RegisterRepo RRepo;

    


    @Override
    public void createEvent(Events e,int id) {
       e.setAdmin_id(id);
       repo.save(e);
    }



    @Override
    public List<Events> showevents(int id) {
        return repo.findAllByAdmin_id(id);
    }



    @Override
    public void registerEvent(String details, String event_id,int user_id,Participants p ) {
        Registers r = new Registers();
        r.setEvent_id(event_id);
        r.setUser_id(user_id);
        Map<String,String> temp = new HashMap<>();
        System.out.println(details);
        String[] strings = details.replaceAll("\\[", "")
                                .replaceAll(" ", "")
                              .replaceAll("]", "")
                              .split(",");
        System.out.println(strings);                 
        // list of object
        for (String detail : strings) {
             System.out.println(detail);
            switch (detail) {
                case "emailid": temp.put("emailid",p.getEmailid());
                    break;
                case "phno" : temp.put("phno",String.valueOf(p.getPhno()));
            }
        }
        r.setDetails(temp);
        System.out.println(temp);
        System.out.println(r.getDetails());
        RRepo.save(r);
    }



    @Override
    public List<Registers> showParticipants(String id) {
        System.out.println(id);
        return RRepo.findAllByEvent_id(id);
    }

}
