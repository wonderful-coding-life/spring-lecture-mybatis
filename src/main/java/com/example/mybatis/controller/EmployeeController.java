package com.example.mybatis.controller;

import com.example.mybatis.mapper.EmployeeMapper;
import com.example.mybatis.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeMapper employeeMapper;
    @GetMapping
    public List<Employee> getEmployees() {
        return employeeMapper.selectAll();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        var employee = employeeMapper.selectById(id);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return employeeMapper.selectById(id);
    }
    @PostMapping
    public Employee postEmployee(@RequestBody Employee employee) {
        employeeMapper.insert(employee);
        return employee;
    }
    @PutMapping
    public Employee putEmployee(@RequestBody Employee employee) {
        employeeMapper.update(employee);
        return employee;
    }
    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeMapper.delete(id);
    }
}
