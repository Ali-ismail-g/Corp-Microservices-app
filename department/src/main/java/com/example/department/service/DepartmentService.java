package com.example.department.service;

import com.example.department.Repository.DepartmentRepository;
import com.example.department.client.EmployeeClient;
import com.example.department.dto.response.DepartmentResponse;
import com.example.department.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeClient employeeClient) {
        this.departmentRepository = departmentRepository;
        this.employeeClient = employeeClient;
    }

    public Department saveDepartment(Department employee) {
        return departmentRepository.save(employee);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public DepartmentResponse getEmployeesForDepartment(Integer departmentId) {
        var department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        var employees = employeeClient.findAllEmployeeForDepartment(departmentId);
        return DepartmentResponse.builder()
                .name(department.getName())
                .organization(department.getOrganization())
                .employees(employees)
                .build();
    }
}
