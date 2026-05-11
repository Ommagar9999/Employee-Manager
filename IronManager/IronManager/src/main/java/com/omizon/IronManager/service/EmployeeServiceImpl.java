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

        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(employee.getName());
        entity.setEmail(employee.getEmail());
        entity.setPhone(employee.getPhone());

        employeeRepository.save(entity);

        return "Saved Successfully";
    }

    @Override
    public List<Employee> readEmployee() {

        List<EmployeeEntity> list = employeeRepository.findAll();
        List<Employee> result = new ArrayList<>();

        for (EmployeeEntity e : list) {
            Employee emp = new Employee();
            emp.setId(e.getId());
            emp.setName(e.getName());
            emp.setEmail(e.getEmail());
            emp.setPhone(e.getPhone());
            result.add(emp);
        }

        return result;
    }

    @Override
    public boolean deleteEmployee(long id) {

        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }


    @Override
    public String updateEmployee(Long id, Employee employee) {

        Optional<EmployeeEntity> optional = employeeRepository.findById(id);

        if (optional.isPresent()) {

            EmployeeEntity existing = optional.get();

            existing.setName(employee.getName());
            existing.setEmail(employee.getEmail());
            existing.setPhone(employee.getPhone());

            employeeRepository.save(existing);

            return "Update Successfully";
        }

        return "Employee Not Found";
    }
}