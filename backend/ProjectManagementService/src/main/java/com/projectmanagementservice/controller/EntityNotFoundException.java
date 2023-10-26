package com.projectmanagementservice.controller;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
