package com.example.mybatis.mapper;

import com.example.mybatis.model.Employee;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Select("SELECT * FROM employee")
    List<Employee> selectAll();
    @Select("SELECT * FROM employee WHERE id=#{id}")
    Employee selectById(int id);
    @Insert("INSERT INTO employee(name, address, company) VALUES(#{name}, #{address}, #{company})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Employee employee);
    @Update("UPDATE employee SET name=#{name}, address=#{address}, company=#{company} WHERE id=#{id}")
    int update(Employee employee);
    @Delete("DELETE FROM employee WHERE id=#{id}")
    int delete(int id);
}
