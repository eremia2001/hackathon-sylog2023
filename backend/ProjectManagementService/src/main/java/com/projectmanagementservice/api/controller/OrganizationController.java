package com.projectmanagementservice.api.controller;

import com.projectmanagementservice.persistence.model.Organization;
import com.projectmanagementservice.persistence.service.OrganizationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizationController {
    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping("/organizations")
    List<Organization> getOrganizations(){
        return organizationService.findAll();
    }

    @GetMapping("/organizations/{id}")
    Organization getOrganization(@PathVariable Long id){
        return organizationService.findById(id);
    }

    @PostMapping("/organizations/create")
    ResponseEntity<Organization> addOrganization(@RequestBody Organization organization){
        return ResponseEntity.status(HttpStatus.OK).body(organizationService.save(organization));
    }

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    String projectNotFoundHandler(EntityNotFoundException e){
        return e.getMessage();
    }
}
