package com.takeaway.empmgmt.controller;

import com.takeaway.empmgmt.model.Employee;
import com.takeaway.empmgmt.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("empmgmt")
public class EmployeeResource {

    @Autowired
    public EmployeeService employeeService;


    @PostMapping(value = "/employees",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String create(@RequestBody Employee employee){
        if(employeeService.saveEmployee(employee))
            return "success";
        else
            return "failed";
    }

    @GetMapping(value = "/employees/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId){
        if(employeeService.getEmployee(employeeId)!=null)
            return employeeService.getEmployee(employeeId);
        else
            return new Employee();
    }

}
