package com.takeaway.empmgmt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "events")
public class Events {

    @Id
    private String id;
    private LocalDateTime currentDateAndTime;
    private String event;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCurrentDateAndTime() {
        return currentDateAndTime;
    }

    public void setCurrentDateAndTime(LocalDateTime currentDateAndTime) {
        this.currentDateAndTime = currentDateAndTime;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
