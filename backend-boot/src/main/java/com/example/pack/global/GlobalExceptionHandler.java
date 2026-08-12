package com.example.pack.global;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<GlobalResponseDto> handleInvalidData(MethodArgumentNotValidException ex){
                GlobalResponseDto dto = new GlobalResponseDto(
                        ex.getFieldErrors()
                                .stream()
                                .map(fex -> fex.getDefaultMessage())
                                .toList()
                );
                return ResponseEntity.badRequest().body(dto);
        }
}
