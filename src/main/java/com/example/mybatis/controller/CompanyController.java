package com.example.mybatis.controller;

import com.example.mybatis.mapper.CompanyMapper;
import com.example.mybatis.model.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyMapper companyMapper;
    @GetMapping
    public List<Company> getCompanies() {
        return companyMapper.selectAll();
    }
    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable int id) {
        var employee = companyMapper.selectById(id);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return companyMapper.selectById(id);
    }
    @PostMapping
    public Company postCompany(@RequestBody Company company) {
        companyMapper.insert(company);
        return company;
    }
    @PutMapping("/{id}")
    public Company putCompany(@PathVariable int id, @RequestBody Company company) {
        company.setId(id);
        companyMapper.update(company);
        return company;
    }
    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable int id) {
        companyMapper.delete(id);
    }
}
