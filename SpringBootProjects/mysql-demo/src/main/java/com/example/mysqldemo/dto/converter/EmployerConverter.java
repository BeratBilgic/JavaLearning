package com.example.mysqldemo.dto.converter;

import com.example.mysqldemo.dto.EmployerDto;
import com.example.mysqldemo.model.Employer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmployerConverter {
    private final EmployerEmployeeDtoConverter employerEmployeeDtoConverter;

    public EmployerDto convertToDto(Employer from){
        return EmployerDto.builder()
                .id(from.getId())
                .name(from.getName())
                .companyName(from.getCompanyName())
                .employees(from.getEmployees() == null ? null :
                                from.getEmployees().stream()
                                .map(employerEmployeeDtoConverter::convert)
                                .collect(Collectors.toSet()))
                .build();
    }
}
