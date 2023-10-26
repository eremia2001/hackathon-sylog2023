package com.projectmanagementservice.controller;

import com.projectmanagementservice.model.Organization;
import com.projectmanagementservice.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizationController {
    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationController(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @GetMapping("/organizations")
    List<Organization> getOrganizations(){
        return organizationRepository.findAll();
    }

    @GetMapping("/organizations/{id}")
    Organization getOrganization(@PathVariable Long id){
        return organizationRepository.getReferenceById(id);
    }

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    String projectNotFoundHandler(EntityNotFoundException e){
        return e.getMessage();
    }
}
