package com.omizon.IronManager.service;

import com.omizon.IronManager.Entity.Employee;

import java.util.List;

public interface EmployeeService {

    String createEmployee(Employee employee);

    List<Employee> readEmployee();

    boolean deleteEmployee(long id);
    String updateEmployee(Long id, Employee employee);


}