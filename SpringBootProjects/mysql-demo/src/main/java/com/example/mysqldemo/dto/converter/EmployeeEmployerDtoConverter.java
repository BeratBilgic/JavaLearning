package com.example.mysqldemo.dto.converter;

import com.example.mysqldemo.dto.EmployeeEmployerDto;
import com.example.mysqldemo.dto.EmployerEmployeeDto;
import com.example.mysqldemo.model.Employer;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeEmployerDtoConverter {

    public EmployeeEmployerDto convert(Optional<Employer> from){
        return from.map(f -> EmployeeEmployerDto.builder()
                .id(f.getId())
                .name(f.getName())
                .companyName(f.getCompanyName()).build()).orElse(null);
/*
        return EmployeeEmployerDto.builder()
                .id(from.getId())
                .name(from.getName())
                .companyName(from.getCompanyName())
                .build();

 */
    }
}
