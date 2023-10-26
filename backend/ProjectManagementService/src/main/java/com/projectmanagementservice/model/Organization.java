package com.projectmanagementservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Date startDate;

    @Column
    private String address;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String url;

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Member> members;

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    private Set<Project> projects;
}
