package com.example.mysqldemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmployerDto {
    private Long id;
    private String name;
    private String companyName;
    private Set<EmployerEmployeeDto> employees;
}
