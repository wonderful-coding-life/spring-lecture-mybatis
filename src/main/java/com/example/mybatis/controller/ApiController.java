package com.example.mybatis.controller;

import com.example.mybatis.aop.LogExecutionTime;
import com.example.mybatis.dto.CompanyDto;
import com.example.mybatis.dto.DashboardDto;
import com.example.mybatis.model.Employee;
import com.example.mybatis.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {
    private final ApiService apiService;
    @GetMapping("/dashboard")
    @LogExecutionTime
    public DashboardDto getDashboard() {
        return apiService.getDashboard();
    }

    @GetMapping("/company/{id}")
    public CompanyDto getCompany(@PathVariable int id) {
        return apiService.getCompany(id);
    }

    @PostMapping("/employee")
    public void postEmployee(@RequestBody List<Employee> employees) {
        apiService.saveEmployees(employees);
    }
}
