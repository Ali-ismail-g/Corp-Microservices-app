package com.example.department.client;


import com.example.department.dto.request.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "employee", url = "${application.config.employee.url}")
public interface EmployeeClient {
    @GetMapping("/department/{departmentId}")
    List<Employee> findAllEmployeeForDepartment(@PathVariable("departmentId") Integer departmentId);
}
