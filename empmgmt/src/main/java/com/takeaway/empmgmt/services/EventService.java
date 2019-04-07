package com.takeaway.empmgmt.services;

import com.takeaway.empmgmt.model.Events;
import com.takeaway.empmgmt.respository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EventService {

    @Autowired
    public EventRepository eventRepository;

    public List<Events> getAllEvents(){
        return eventRepository.findAllByOrderByCurrentDateAndTime();
    }
}
