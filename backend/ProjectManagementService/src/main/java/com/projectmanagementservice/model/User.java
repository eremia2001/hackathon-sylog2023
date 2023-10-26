package com.projectmanagementservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.MEMBER;

    // todo password hash ?

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;

    @OneToMany(mappedBy = "assignedUser", fetch = FetchType.LAZY)
    private Set<Task> assignedTasks;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Comment> writtenComments;
}
