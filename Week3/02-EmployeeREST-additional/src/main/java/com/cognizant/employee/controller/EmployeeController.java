package com.cognizant.employee.controller;

import com.cognizant.employee.model.Employee;
import com.cognizant.employee.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")   // allow an Angular/React front-end to consume this API
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        LOGGER.info("START getAllEmployees()");
        List<Employee> employees = employeeService.getAllEmployees();
        LOGGER.info("END getAllEmployees() - {} employees", employees.size());
        return employees;
    }
}
