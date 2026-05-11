package com.omizon.IronManager.controller;

import com.omizon.IronManager.Entity.Employee;
import com.omizon.IronManager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmp() {
        return employeeService.readEmployee();
    }

    @PostMapping("/employees")
    public String createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmp(@PathVariable Long id) {
        if (employeeService.deleteEmployee(id)) {
            return "Delete Successfully";
        }
        return "Not Found";
    }


    @PutMapping("/employees/{id}")
    public String putMathodName(@PathVariable Long id , @RequestBody Employee employee)
    {


        return employeeService.updateEmployee(id,employee);
    }
}


