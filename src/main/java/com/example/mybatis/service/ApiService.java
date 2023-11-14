package com.example.mybatis.service;

import com.example.mybatis.dto.CompanyDto;
import com.example.mybatis.dto.DashboardDto;
import com.example.mybatis.mapper.CompanyMapper;
import com.example.mybatis.mapper.EmployeeMapper;
import com.example.mybatis.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.ErrorResponse;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiService {
    private final CompanyMapper companyMapper;
    private final EmployeeMapper employeeMapper;
    public DashboardDto getDashboard() {
        return DashboardDto.builder()
                .companyCount(companyMapper.count())
                .employeeCount(employeeMapper.count()).build();
    }
    public CompanyDto getCompany(int id) {
        var company = companyMapper.selectById(id);
        var employees = employeeMapper.selectAll();
        return CompanyDto.builder()
                .name(company.getName())
                .address(company.getAddress())
                .employees(employees)
                .build();
    }

    @Transactional
    public void saveEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            if ("홍길철1".equals(employee.getName())) { // check employee in black list
                throw new RuntimeException("블랙리스트에 포함된 직원이 있습니다");
            }
            employeeMapper.insert(employee);
        }
    }


}
