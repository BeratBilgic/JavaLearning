package com.example.mysqldemo.controller;

import com.example.mysqldemo.dto.request.CreateEmployeeRequest;
import com.example.mysqldemo.dto.EmployeeDto;
import com.example.mysqldemo.dto.request.UpdateEmployeeRequest;
import com.example.mysqldemo.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody CreateEmployeeRequest request){
        return ResponseEntity.ok(service.addEmployee(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@Valid @PathVariable Long id){
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@Valid @PathVariable Long id,
                                                      @RequestBody UpdateEmployeeRequest request){
        return ResponseEntity.ok(service.updateEmployee(id, request));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEmployee(@Valid @PathVariable Long id){
        service.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }
}
