package com.example.mysqldemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmployeeEmployerDto {
    private Long id;
    private String name;
    private String companyName;
}
