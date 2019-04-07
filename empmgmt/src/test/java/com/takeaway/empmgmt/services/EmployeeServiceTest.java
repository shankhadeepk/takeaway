package com.takeaway.empmgmt.services;

import com.takeaway.empmgmt.model.DatabaseSequence;
import com.takeaway.empmgmt.model.Department;
import com.takeaway.empmgmt.model.Employee;
import com.takeaway.empmgmt.model.Events;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    public EmployeeService employeeService;

    @Autowired
    public MongoTemplate mongoTemplate;

    @Before
    public void setUp(){
        mongoTemplate.dropCollection(Employee.class);
        mongoTemplate.dropCollection(Department.class);
        mongoTemplate.dropCollection(DatabaseSequence.class);
        mongoTemplate.dropCollection(Events.class);
        Employee employee=new Employee();
        employee.setFullName("Dummy1");
        employee.setEmail("dummy1@gmail.com");
        employee.setDepartmentName("Accounts");
        employee.setBirthDay("11 MAY 1984");
        employeeService.saveEmployee(employee);
    }
    @After
    public void destroy(){
        mongoTemplate.dropCollection(Employee.class);
        mongoTemplate.dropCollection(Department.class);
        mongoTemplate.dropCollection(DatabaseSequence.class);
        mongoTemplate.dropCollection(Events.class);
    }

    @Test
    public void saveEmployee() {
        Employee employee=new Employee();
        employee.setFullName("Dummy Name");
        employee.setEmail("dummy@gmail.com");
        employee.setDepartmentName("Accounts");
        employee.setBirthDay("13 MAY 1984");
        assertTrue(employeeService.saveEmployee(employee));
    }

    @Test
    public void getEmployee() {
        assertNotNull(employeeService.getEmployee("1"));
    }

    @Test
    public void updateEmployee() {
        Employee employee=new Employee();
        employee.setUuid("1");
        employee.setFullName("Dummy1 LastDummy1");
        employee.setEmail("Dummy1@gmail.com");
        employee.setDepartmentName("Accounts");
        employee.setBirthDay("11 MAY 1984");
        assertEquals("Dummy1 LastDummy1",employeeService.updateEmployee(employee,"1").getFullName());
    }

    @Test
    public void deleteEmployee() {
        assertTrue(employeeService.deleteEmployee("1"));
    }
}