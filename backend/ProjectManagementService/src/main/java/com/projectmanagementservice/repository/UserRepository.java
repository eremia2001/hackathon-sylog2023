package com.projectmanagementservice.repository;

import com.projectmanagementservice.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Member,Long> {
}
