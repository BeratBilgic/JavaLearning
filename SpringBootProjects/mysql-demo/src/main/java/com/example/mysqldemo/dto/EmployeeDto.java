package com.example.mysqldemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmployeeDto {
    private Long id;
    private String name;
    private float salary;
    private EmployeeEmployerDto employer;
}
