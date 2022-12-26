package com.example.mysqldemo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "employers")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String companyName;

    @OneToMany(mappedBy = "employer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Employee> employees;
}
