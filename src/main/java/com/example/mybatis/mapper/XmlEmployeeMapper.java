package com.example.mybatis.mapper;

import com.example.mybatis.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface XmlEmployeeMapper {
    List<Employee> selectAll(@Param("orderBy") String orderBy);
    Employee selectById(int id);
}
