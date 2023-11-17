package com.example.mybatis.controller;

import com.example.mybatis.model.Company;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CompanyControllerTest {
    @Autowired
    private TestRestTemplate template;

    @Test
    public void getCompanyById() {
        ResponseEntity<Company> response = template.getForEntity("/company/3", Company.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isEqualTo(3);
        assertThat(response.getBody().getName()).isEqualTo("신한카드");
    }

    @Test
    public void postCompany() {
        var company = Company.builder().id(0).name("신한카드").address("서울시 중구 을지로 100").build();
        var request = new HttpEntity<Company>(company);
        ResponseEntity<Company> response = template.postForEntity("/company", request, Company.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getId()).isNotZero();
    }
}