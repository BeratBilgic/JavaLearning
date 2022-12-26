package com.example.mysqldemo.dto.converter;

import com.example.mysqldemo.dto.EmployeeDto;
import com.example.mysqldemo.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class EmployeeDtoConverter {
    private final EmployeeEmployerDtoConverter employeeEmployerDtoConverter;

    public EmployeeDto convertToDto(Employee from){
        return EmployeeDto.builder()
                .id(from.getId())
                .name(from.getName())
                .salary(from.getSalary())
                .employer(employeeEmployerDtoConverter.convert(Optional.ofNullable(from.getEmployer())))
                .build();
    }
}
