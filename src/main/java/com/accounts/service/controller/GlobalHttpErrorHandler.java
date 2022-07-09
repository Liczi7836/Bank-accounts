package com.accounts.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountsNotFoundException.class)
    public ResponseEntity<String> handleAccountsNotFoundException(AccountsNotFoundException exception){
        return new ResponseEntity<>("Accounts with given customer id doesn't exist", HttpStatus.BAD_REQUEST);
    }
}
