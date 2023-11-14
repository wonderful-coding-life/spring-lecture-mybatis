package com.example.mybatis.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardDto {
    private int companyCount;
    private int employeeCount;
}
