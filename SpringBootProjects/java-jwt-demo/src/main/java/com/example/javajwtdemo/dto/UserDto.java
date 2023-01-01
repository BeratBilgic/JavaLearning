package com.example.javajwtdemo.dto;

import com.example.javajwtdemo.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    Long id;
    private String username;
    private String password;
    private Role role;
}
