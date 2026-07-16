package com.cognizant.employee.controller;

import com.cognizant.employee.model.Department;
import com.cognizant.employee.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        LOGGER.info("START getAllDepartments()");
        List<Department> departments = departmentService.getAllDepartments();
        LOGGER.info("END getAllDepartments() - {} departments", departments.size());
        return departments;
    }
}
