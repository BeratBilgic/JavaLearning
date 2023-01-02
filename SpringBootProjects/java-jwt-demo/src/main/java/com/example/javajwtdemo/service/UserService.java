package com.example.javajwtdemo.service;

import com.example.javajwtdemo.dto.UserDto;
import com.example.javajwtdemo.dto.UserDtoConverter;
import com.example.javajwtdemo.exception.GenericException;
import com.example.javajwtdemo.model.User;
import com.example.javajwtdemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@Slf4j
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

    public UserDto getUserById(Long id){
        return dtoConverter.convertToDto(findUserById(id));
    }

    protected User findUserById(Long id){
        return repository.findById(id).orElseThrow(notFoundUser(HttpStatus.NOT_FOUND));
    }

    public UserDto getMyselfById(Long id){
        UserDto fromDB = getUserById(id);
        UserDto fromToken = findUserInContext();

        if (fromDB.getUsername() != fromToken.getUsername())
            throw GenericException.builder()
                    .httpStatus(HttpStatus.FORBIDDEN)
                    .errorMessage("You are not authorized to access this user's information")
                    .build();

        return fromDB;
    }

    public Boolean existsByUsername(String username){
        return repository.existsByUsername(username);
    }

    @Transactional
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
