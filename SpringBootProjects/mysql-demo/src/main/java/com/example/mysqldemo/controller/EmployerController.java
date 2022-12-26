package com.example.mysqldemo.controller;

import com.example.mysqldemo.dto.request.CreateEmployerRequest;
import com.example.mysqldemo.dto.EmployerDto;
import com.example.mysqldemo.service.EmployerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employer")
@RequiredArgsConstructor
public class EmployerController {
    private final EmployerService service;

    @PostMapping("/create")
    public ResponseEntity<EmployerDto> createEmployer(@RequestBody CreateEmployerRequest request){
        return ResponseEntity.ok(service.createEmployer(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployerDto> getEmployer(@Valid @PathVariable Long id){
        return ResponseEntity.ok(service.getEmployeeByID(id));
    }
}
