package com.takeaway.empmgmt.respository;

import com.takeaway.empmgmt.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
    List<Employee> findByUuid(String uuid);
}
