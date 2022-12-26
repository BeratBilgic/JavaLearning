package com.example.mysqldemo.service;

import com.example.mysqldemo.dto.request.CreateEmployerRequest;
import com.example.mysqldemo.dto.EmployerDto;
import com.example.mysqldemo.dto.converter.EmployerConverter;
import com.example.mysqldemo.exception.GenericException;
import com.example.mysqldemo.model.Employer;
import com.example.mysqldemo.repository.EmployerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployerService {

    private final EmployerRepository repository;
    private final EmployerConverter dtoConverter;

    public EmployerDto createEmployer(CreateEmployerRequest request){
        return dtoConverter.convertToDto(repository.save(Employer.builder()
                .name(request.getName())
                .companyName(request.getCompanyName())
                .build()));
    }

    protected Employer findEmployeeById(Long id){
        return repository.findEmployerById(id).orElseThrow(
                () -> GenericException.builder()
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .errorMessage("employer not found")
                        .build());
    }

    public EmployerDto getEmployeeByID(Long Id){
        return dtoConverter.convertToDto(findEmployeeById(Id));
    }
}
