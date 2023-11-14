package com.example.mybatis.mapper;

import com.example.mybatis.model.Company;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface CompanyMapper {
    @Select("SELECT * FROM company")
    List<Company> selectAll();
    @Select("SELECT * FROM company WHERE id=#{id}")
    Company selectById(int id);
    @Insert("INSERT INTO company(name, address) VALUES(#{name}, #{address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Company employee);
    @Update("UPDATE company SET name=#{name}, address=#{address} WHERE id=#{id}")
    int update(Company employee);
    @Delete("DELETE FROM company WHERE id=#{id}")
    int delete(int id);
    @Select("SELECT COUNT(*) FROM company")
    int count();
}
