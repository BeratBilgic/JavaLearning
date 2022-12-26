package com.example.mysqldemo.service;

import com.example.mysqldemo.dto.request.CreateEmployeeRequest;
import com.example.mysqldemo.dto.EmployeeDto;
import com.example.mysqldemo.dto.converter.EmployeeDtoConverter;
import com.example.mysqldemo.dto.request.UpdateEmployeeRequest;
import com.example.mysqldemo.exception.GenericException;
import com.example.mysqldemo.model.Employee;
import com.example.mysqldemo.model.Employer;
import com.example.mysqldemo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeDtoConverter dtoConverter;
    private final EmployerService employerService;

    public EmployeeDto addEmployee(CreateEmployeeRequest request){
        Employer employer = employerService.findEmployeeById(request.getEmployerId());

        return dtoConverter.convertToDto(repository.save(Employee.builder()
                .name(request.getName())
                .salary(request.getSalary())
                .employer(employer)
                .build()));
    }

    protected Employee findEmployeeById(Long Id){
        return repository.findEmployeeById(Id).orElseThrow(
                () -> GenericException.builder()
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .errorMessage("employee not found")
                        .build());
    }

    public EmployeeDto getEmployeeById(Long Id){
        return dtoConverter.convertToDto(findEmployeeById(Id));
    }

    public EmployeeDto updateEmployee(Long id, UpdateEmployeeRequest request){
        Employer employer = employerService.findEmployeeById(request.getEmployerId());

        Employee employee = findEmployeeById(id);

        employee.setName(request.getName());
        employee.setSalary(request.getSalary());
        employee.setEmployer(employer);

        return dtoConverter.convertToDto(repository.save(employee));
    }

    public void deleteEmployee(Long id){
        repository.deleteById(id);
    }
}
