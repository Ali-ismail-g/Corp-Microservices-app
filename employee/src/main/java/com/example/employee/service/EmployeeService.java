package com.example.employee.service;

import com.example.employee.Repository.EmployeeRepository;
import com.example.employee.entity.Employee;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public List<Employee> findAllEmployeeForDepartment(Integer departmentId) {
        return employeeRepository.findAllByDepartmentId(departmentId);
    }
}
