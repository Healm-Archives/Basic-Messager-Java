package com.example.pack.global;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<List<String>> handleInvalidData(MethodArgumentNotValidException ex){
                return ResponseEntity.badRequest().body(
                        ex.getFieldErrors()
                                .stream()
                                .map(fex -> fex.getDefaultMessage())
                                .toList()
                );
        }
}
