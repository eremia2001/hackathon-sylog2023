package com.projectmanagementservice.persistence.crud;

import com.projectmanagementservice.exception.NotFoundException;
import com.projectmanagementservice.persistence.model.Organization;
import com.projectmanagementservice.persistence.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudOrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    CrudMemberService crudMemberService;

    public Organization findById(Long id) {
        return organizationRepository.findById(id).orElseThrow(() -> new NotFoundException("Project with ID " + id + " not found!"));
    }

    public List<Organization> findAll(){
        return organizationRepository.findAll();
    }

    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }

    public void deleteOrganization(Long orgId){
        organizationRepository.deleteById(orgId);
    }
}
