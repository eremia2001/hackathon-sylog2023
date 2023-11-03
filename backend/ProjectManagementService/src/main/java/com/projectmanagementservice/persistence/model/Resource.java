package com.projectmanagementservice.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
