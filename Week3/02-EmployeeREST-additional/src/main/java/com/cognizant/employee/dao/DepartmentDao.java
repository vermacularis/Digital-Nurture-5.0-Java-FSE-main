package com.cognizant.employee.dao;

import com.cognizant.employee.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Reads the static department list from employee.xml (Spring XML configuration).
 */
@Repository
public class DepartmentDao {

    private static List<Department> DEPARTMENT_LIST;

    @SuppressWarnings("unchecked")
    public DepartmentDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        DEPARTMENT_LIST = new ArrayList<>((List<Department>) context.getBean("departmentList"));
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
