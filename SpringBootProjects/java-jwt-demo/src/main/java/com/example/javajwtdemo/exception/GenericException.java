package com.example.javajwtdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class GenericException extends RuntimeException{
    HttpStatus httpStatus;
    String errorMessage;
}
