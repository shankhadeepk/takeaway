package com.takeaway.empmgmt.controller;

import com.takeaway.empmgmt.model.Employee;
import com.takeaway.empmgmt.services.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("empmgmt")
@Api(value="Employee Management Service", description = "operations on Employee data")
public class EmployeeResource {

    @Autowired
    public EmployeeService employeeService;

    @ApiOperation(value = "Add Employee details",response = String.class)
    @PostMapping(value = "/employees",consumes = MediaType.APPLICATION_JSON_VALUE)
    public String create(
            @ApiParam(value = "Employee to be stored in database", required = true)
            @RequestBody Employee employee){
        if(employeeService.saveEmployee(employee))
            return "success";
        else
            return "failed";
    }

    @ApiOperation(value = "Get employee by employeeId",response = String.class)
    @GetMapping(value = "/employees/{employeeId}")
    public Employee getEmployee(
            @ApiParam(value = "Employee details retrieved using employeeId", required = true)
            @PathVariable String employeeId){
        if(employeeService.getEmployee(employeeId)!=null)
            return employeeService.getEmployee(employeeId);
        else
            return new Employee();
    }

}
