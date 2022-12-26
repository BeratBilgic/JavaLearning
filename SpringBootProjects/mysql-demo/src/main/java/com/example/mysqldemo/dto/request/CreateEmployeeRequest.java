package com.example.mysqldemo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateEmployeeRequest {
    private String name;
    private float salary;
    private Long employerId;
}
