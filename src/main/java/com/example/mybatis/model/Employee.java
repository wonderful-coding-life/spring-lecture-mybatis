package com.example.mybatis.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Employee {
    private int id;
    private String name;
    private String address;
    private int company;
}
