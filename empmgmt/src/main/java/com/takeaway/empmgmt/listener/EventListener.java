package com.takeaway.empmgmt.listener;

import com.takeaway.empmgmt.model.Events;
import com.takeaway.empmgmt.respository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EventListener {

    private static final String TOPIC="employee";
    private static final String GROUPID="EMPMGMT";

    @Autowired
    public EventRepository eventRepository;

    @KafkaListener(topics = TOPIC,groupId = GROUPID)
    public void eventConsumer(String message){
        System.out.println("Event Listener called");
        Events events=new Events();
        events.setCurrentDateAndTime(LocalDateTime.now());
        events.setEvent(message);

        eventRepository.save(events);
    }
}
