package com.projectmanagementservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE, reason="Update not possible, value not known")
public class BadContentException extends RuntimeException{
    public BadContentException(String errorMessage){
        super(errorMessage);
    }
}