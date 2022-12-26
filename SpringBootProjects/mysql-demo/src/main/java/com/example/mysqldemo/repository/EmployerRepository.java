package com.example.mysqldemo.repository;

import com.example.mysqldemo.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
    Optional<Employer> findEmployerById(Long id);
}
