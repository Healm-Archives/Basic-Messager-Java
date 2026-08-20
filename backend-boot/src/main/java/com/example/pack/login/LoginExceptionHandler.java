package com.example.pack.login;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pack.global.GlobalResponseDto;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice(assignableTypes = {LoginController.class})
public class LoginExceptionHandler {
        
        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<GlobalResponseDto> handleDuplicate(DataIntegrityViolationException e){

                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body(new GlobalResponseDto(List.of("Duplicate Entry")));
        }

        @ExceptionHandler(TransactionSystemException.class)
        public ResponseEntity<GlobalResponseDto> handleTransactionException(TransactionSystemException e){
                Throwable rootCause = e.getRootCause();
                
                if (rootCause instanceof ConstraintViolationException violation) {
                        List<String> message = violation.getConstraintViolations()
                                .stream()
                                .map(v -> v.getMessage())
                                .toList();

                        GlobalResponseDto dto = new GlobalResponseDto(message);

                        return ResponseEntity.badRequest().body(dto);
                }

                return ResponseEntity.internalServerError().body(
                        new GlobalResponseDto(List.of("Unhandled Exception"))
                );

        }
        
        @ExceptionHandler(AuthenticationException.class)
        public ResponseEntity<GlobalResponseDto> handleBadLogin(AuthenticationException e){
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body(new GlobalResponseDto(List.of("Bad Credential")));
        }
}
