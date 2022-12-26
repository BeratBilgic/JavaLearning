package com.example.mysqldemo.dto.converter;

import com.example.mysqldemo.dto.EmployerEmployeeDto;
import com.example.mysqldemo.model.Employee;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class EmployerEmployeeDtoConverter {
    
    public EmployerEmployeeDto convert(Employee from){

        return EmployerEmployeeDto.builder()
                .id(Objects.requireNonNull(from.getId()))
                .name(from.getName())
                .salary(from.getSalary())
                .build();
    }
}
