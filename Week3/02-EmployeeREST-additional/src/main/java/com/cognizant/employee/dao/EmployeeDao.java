package com.cognizant.employee.dao;

import com.cognizant.employee.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Reads the static employee list from employee.xml (Spring XML configuration).
 */
@Repository
public class EmployeeDao {

    private static List<Employee> EMPLOYEE_LIST;

    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = new ArrayList<>((List<Employee>) context.getBean("employeeList"));
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}
