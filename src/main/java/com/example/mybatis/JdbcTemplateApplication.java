package com.example.mybatis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.example.mybatis.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

//@Component
@RequiredArgsConstructor
@Slf4j
public class JdbcTemplateApplication implements ApplicationRunner {
    private final JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var employees = jdbcTemplate.query("SELECT * FROM employee", new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                return Employee.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .address(resultSet.getString("address"))
                        .build();
            }
        });
        log.info("{}", employees);
    }
}
