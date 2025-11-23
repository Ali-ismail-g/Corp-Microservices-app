package com.example.department.controller;

import com.example.department.dto.response.DepartmentResponse;
import com.example.department.entity.Department;
import com.example.department.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<Department> saveEmployee(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.saveDepartment(department));
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllEmployees() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/with-employees/{departmentId}")
    public ResponseEntity<DepartmentResponse> getEmployeesForDepartment(@PathVariable("departmentId") Integer departmentId) {
        return ResponseEntity.ok(departmentService.getEmployeesForDepartment(departmentId));
    }
}
