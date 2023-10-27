package com.projectmanagementservice.api.controller;

import com.projectmanagementservice.persistence.model.Organization;
import com.projectmanagementservice.persistence.crud.CrudOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizationController {
    private final CrudOrganizationService crudOrganizationService;

    @Autowired
    public OrganizationController(CrudOrganizationService crudOrganizationService) {
        this.crudOrganizationService = crudOrganizationService;
    }

    @GetMapping("/api/organizations")
    List<Organization> getOrganizations(){
        return crudOrganizationService.findAll();
    }

    @GetMapping("/api/organizations/{id}")
    Organization getOrganization(@PathVariable Long id){
        return crudOrganizationService.findById(id);
    }

    @PostMapping("/api/organizations/create")
    ResponseEntity<Organization> addOrganization(@RequestBody Organization organization){
        return ResponseEntity.status(HttpStatus.OK).body(crudOrganizationService.save(organization));
    }

    @DeleteMapping("/api/organizations/delete/{orgId}")
    ResponseEntity<String> deleteOrganization(@PathVariable Long orgId){
        crudOrganizationService.deleteOrganization(orgId);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted Organization");
    }
}
