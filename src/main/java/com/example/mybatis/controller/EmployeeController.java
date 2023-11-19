package com.example.mybatis.controller;

import com.example.mybatis.mapper.EmployeeMapper;
import com.example.mybatis.mapper.XmlEmployeeMapper;
import com.example.mybatis.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeMapper employeeMapper;
    private final XmlEmployeeMapper xmlEmployeeMapper;

    @GetMapping
    public List<Employee> getEmployees(@RequestParam(required = false) String orderBy) {
        return xmlEmployeeMapper.selectAll(orderBy);
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        var employee = xmlEmployeeMapper.selectById(id);
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
    @PutMapping("/{id}")
    public Employee putEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employee.setId(id);
        employeeMapper.update(employee);
        return employee;
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeMapper.delete(id);
    }
}
