package com.example.department.dto.response;

import com.example.department.dto.request.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponse {
    private String name;
    private String organization;
    List<Employee> employees;
}
