package com.takeaway.empmgmt.respository;

import com.takeaway.empmgmt.model.Events;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Events,String> {

    public List<Events> findAllByOrderByCurrentDateAndTime();
}
