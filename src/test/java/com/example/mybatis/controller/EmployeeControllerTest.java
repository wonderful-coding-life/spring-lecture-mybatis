package com.example.mybatis.controller;

import com.example.mybatis.mapper.EmployeeMapper;
import com.example.mybatis.mapper.XmlEmployeeMapper;
import com.example.mybatis.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeMapper employeeMapper;
    @MockBean
    private XmlEmployeeMapper xmlEmployeeMapper;

    @Test
    public void getEmployeeById() throws Exception {
        when(employeeMapper.selectById(1)).thenReturn(Employee.builder().id(1).name("홍길동").address("서울시 강남구 대치동").build());
        when(employeeMapper.selectById(2)).thenReturn(Employee.builder().id(2).name("홍길자").address("서울시 영등포구 여의도동").build());
        when(xmlEmployeeMapper.selectById(1)).thenReturn(Employee.builder().id(1).name("홍길동").address("서울시 강남구 대치동").build());
        when(xmlEmployeeMapper.selectById(2)).thenReturn(Employee.builder().id(2).name("홍길자").address("서울시 영등포구 여의도동").build());
        mockMvc.perform(get("/employee/1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.name").value("홍길동"));
    }

    @Test
    public void getEmployoee() throws Exception {
        var employees = List.of(
                Employee.builder().id(1).name("홍길동").address("서울시 강남구 대치동").build(),
                Employee.builder().id(2).name("홍길자").address("서울시 영등포구 여의도동").build()
        );
        when(xmlEmployeeMapper.selectAll("name")).thenReturn(employees);
        mockMvc.perform(get("/employee?orderBy=name"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[1]").exists())
                .andExpect(jsonPath("$[?(@.name == '%s')]", "홍길동").exists())
                .andExpect(jsonPath("$[?(@.name == '%s')]", "홍길자").exists());
    }
}
