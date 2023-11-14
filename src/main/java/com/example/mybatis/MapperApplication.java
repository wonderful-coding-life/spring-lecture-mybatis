package com.example.mybatis;

import com.example.mybatis.mapper.EmployeeMapper;
import com.example.mybatis.model.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

//@Component
@RequiredArgsConstructor
@Slf4j
public class MapperApplication implements ApplicationRunner {
    private final EmployeeMapper employeeMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var employees = employeeMapper.selectAll();
        for (Employee employee : employees) {
            log.info("{}", employee);
        }
        var employee = employeeMapper.selectById(2);
        log.info("{}", employee);
        employeeMapper.insert(Employee.builder().name("홍길철2").address("서울시 영등포구").company(1).build());
        employeeMapper.update(Employee.builder().id(1).name("홍길철2").address("서울시 영등포구").company(1).build());
        employeeMapper.delete(2);
    }
}
