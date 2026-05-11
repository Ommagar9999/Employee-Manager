package com.omizon.IronManager.service;

import com.omizon.IronManager.Entity.Employee;
import com.omizon.IronManager.Entity.EmployeeEntity;
import com.omizon.IronManager.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String createEmployee(Employee employee) {

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setName(employee.getName());
        employeeEntity.setEmail(employee.getEmail());
        employeeEntity.setPhone(employee.getPhone());

        employeeRepository.save(employeeEntity);

        return "Saved Successfully";
    }

    @Override
    public List<Employee> readEmployee() {

        List<EmployeeEntity> employeeList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();

        for (EmployeeEntity employeeEntity : employeeList) {
            Employee emp = new Employee();

            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());

            employees.add(emp);
        }

        return employees;
    }

    @Override
    public boolean deleteEmployee(long id) {

        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }

        return false;
    }

    // FIXED UPDATE METHOD
    @Override
    public String updateEmployee(Long id, Employee employee) {

        Optional<EmployeeEntity> optionalEmp = employeeRepository.findById(id);

        if (optionalEmp.isPresent()) {

            EmployeeEntity existingEmployee = optionalEmp.get();

            // update values
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setPhone(employee.getPhone());

            employeeRepository.save(existingEmployee);

            return "Update Successfully";
        }

        return "Employee Not Found";
    }
}