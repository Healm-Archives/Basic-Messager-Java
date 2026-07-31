package com.example.pack.login;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice(assignableTypes = {LoginController.class})
public class LoginExceptionHandler {
        
        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<String> handleDuplicate(DataIntegrityViolationException e){
                return new ResponseEntity<>("Duplicate entry", HttpStatus.CONFLICT);
        }

        // @ExceptionHandler(TransactionSystemException.class)
        // public ResponseEntity<List<String>> handleTransactionException(TransactionSystemException e){
        //         Throwable rootCause = e.getRootCause();
                
        //         if (rootCause instanceof ConstraintViolationException violation) {
        //                 List<String> message = violation.getConstraintViolations()
        //                         .stream()
        //                         .map(v -> v.getMessage())
        //                         .toList();

        //                 // return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        //                 return ResponseEntity.badRequest().body(message);
        //         }

        //         return new ResponseEntity<>(List.of("Unhandled exception"), HttpStatus.INTERNAL_SERVER_ERROR);
        //         // return ResponseEntity.internalServerError().build();

        // }
}
