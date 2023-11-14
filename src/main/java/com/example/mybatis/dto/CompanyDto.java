package com.example.mybatis.dto;

import com.example.mybatis.model.Employee;
import lombok.Builder;
import lombok.Data;
import java.util.List;
@Data
@Builder
public class CompanyDto {
    private String name;
    private String address;
    private List<Employee> employees;
}
