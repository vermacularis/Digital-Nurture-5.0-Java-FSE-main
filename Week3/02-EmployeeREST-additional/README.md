# Week 3 (Additional) — Employee/Department REST (Controller–Service–Dao)

Covers the **additional** Spring REST hands-on (doc 3, "All hands-on"): a layered REST service
that serves employee and department data loaded from Spring XML configuration.

## Architecture
```
Controller  ->  Service (@Transactional)  ->  Dao (reads employee.xml)  ->  Model
```

## Run

```bash
mvn spring-boot:run
```

## Endpoints (test in Postman or browser)

| Method | URL | Returns |
|--------|-----|---------|
| GET | `/employees` | 4 employees, each with department + skills |
| GET | `/departments` | 3 departments |

- `employee.xml` defines departments, employees (with skills), and two `util:list` beans
  (`employeeList`, `departmentList`).
- `EmployeeDao` / `DepartmentDao` load those lists into static `EMPLOYEE_LIST` / `DEPARTMENT_LIST`.
- `@CrossOrigin` is enabled so an Angular/React front-end can consume the API (the original
  exercise wires this into the Angular employee screen).
