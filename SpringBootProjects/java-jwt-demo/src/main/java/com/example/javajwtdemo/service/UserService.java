package com.example.javajwtdemo.service;

import com.example.javajwtdemo.dto.UserDto;
import com.example.javajwtdemo.dto.UserDtoConverter;
import com.example.javajwtdemo.exception.GenericException;
import com.example.javajwtdemo.model.User;
import com.example.javajwtdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserDtoConverter dtoConverter;

    public UserDto getUserByUsername(String username){
        return dtoConverter.convertToDto(findUserByUsername(username));
    }

    protected User findUserByUsername(String username){
        return repository.findByUsername(username).orElseThrow(notFoundUser(HttpStatus.NOT_FOUND));
    }
    public Boolean existsByUsername(String username){
        return repository.existsByUsername(username);
    }

    public User saveRepository(User user){
        return repository.save(user);
    }

    public UserDto findUserInContext() {
        final Authentication authentication = Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication()).orElseThrow(notFoundUser(HttpStatus.UNAUTHORIZED));
        final UserDetails details = Optional.ofNullable((UserDetails) authentication.getPrincipal()).orElseThrow(notFoundUser(HttpStatus.UNAUTHORIZED));
        return getUserByUsername(details.getUsername());
    }

    private static Supplier<GenericException> notFoundUser(HttpStatus unauthorized) {
        return () -> GenericException.builder().httpStatus(unauthorized).errorMessage("user not found!").build();
    }
}
