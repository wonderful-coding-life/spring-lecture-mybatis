package com.example.mybatis;

import com.example.mybatis.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//@Component
@Slf4j
public class JdbcApplication implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:demo", "sa", "");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employee");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            var employee = Employee.builder()
                    .id(resultSet.getInt("id"))
                    .name(resultSet.getString("name"))
                    .address(resultSet.getString("address"))
                    .build();
            log.info("{}", employee);
        }
        connection.close();
    }
}
