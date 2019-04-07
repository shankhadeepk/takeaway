package com.takeaway.empmgmt.controller;

import com.takeaway.empmgmt.model.Events;
import com.takeaway.empmgmt.respository.EventRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("empmgmt")
@Api(value="Event Service", description = "Maitaining events on the apis")
public class EventResource {

    @Autowired
    public EventRepository eventRepository;

    @ApiOperation(value = "Get All events",response = String.class)
    @GetMapping(value = "/events")
    public List<Events> getAllEvents(){
        return eventRepository.findAllByOrderByCurrentDateAndTime();
    }
}
