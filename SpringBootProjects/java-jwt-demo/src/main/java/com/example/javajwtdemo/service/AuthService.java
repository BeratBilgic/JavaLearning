package com.example.javajwtdemo.service;

import com.example.javajwtdemo.dto.*;
import com.example.javajwtdemo.exception.GenericException;
import com.example.javajwtdemo.model.Role;
import com.example.javajwtdemo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final TokenService tokenService;
    private final UserDtoConverter dtoConverter;
    private final PasswordEncoder encoder;

    public TokenResponseDTO login(LoginRequest request){
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            return TokenResponseDTO.builder()
                    .accessToken(tokenService.generateToken(auth))
                    .user(userService.getUserByUsername(request.getUsername()))
                    .build();
        }catch (final BadCredentialsException badCredentialsException){
            throw GenericException.builder()
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .errorMessage("Invalid Username or Password")
                    .build();
        }
    }

    @Transactional
    public UserDto signup(SignUpRequest signUpRequest){
        var isAllReadyRegistered = userService.existsByUsername(signUpRequest.getUsername());

        if(isAllReadyRegistered) {
            throw GenericException.builder().httpStatus(HttpStatus.FOUND)
                    .errorMessage("Username:" + signUpRequest.getUsername() + " is already used").build();
        }

        var user = User.builder()
                .username(signUpRequest.getUsername())
                .password(encoder.encode(signUpRequest.getPassword()))
                .role(Role.USER)
                .build();

        return dtoConverter.convertToDto(userService.saveRepository(user));

    }
}
