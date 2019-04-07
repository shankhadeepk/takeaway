package com.takeaway.empmgmt.services;

import com.takeaway.empmgmt.model.Department;
import com.takeaway.empmgmt.model.Employee;
import com.takeaway.empmgmt.respository.DepartmentRepository;
import com.takeaway.empmgmt.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    public SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    public EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentRepository departmentRepository;

    public boolean saveEmployee(Employee employee){

        employee.setUuid(Long.toString(sequenceGeneratorService.generateSequence(Employee.SEQUENCE_NAME)));
        employeeRepository.save(employee);

        List<Department> departments=departmentRepository.findByDeptName(employee.getDepartmentName());

        if(departments!=null && departments.size()>0){
            Department department=departments.get(0);
            addEmployeeToDepartment(department,employee);
            departmentRepository.save(department);
        }else {
            Department department=new Department();
            department.setId(Long.toString(sequenceGeneratorService.generateSequence(Department.SEQUENCE_NAME)));
            department.setDeptName(employee.getDepartmentName());
            addEmployeeToDepartment(department,employee);
            departmentRepository.save(department);
        }

        return true;
    }
    private void addEmployeeToDepartment(Department department,Employee employee){
        if(department.getEmployees()!=null)
            department.getEmployees().add(employee.getUuid());
        else {
            department.setEmployees(new ArrayList<>());
            department.getEmployees().add(employee.getUuid());
        }
    }

    public Employee getEmployee(String employeeId){
        if(employeeRepository.findByUuid(employeeId)!=null && employeeRepository.findByUuid(employeeId).size()>0){
            return employeeRepository.findByUuid(employeeId).get(0);
        }else return null;
    }
}
