package com.girishms.springrestdemo.services;

import com.girishms.springrestdemo.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList();
    Employee saveEmployee(Employee employee);
    Employee getEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee( Employee employee);
}
