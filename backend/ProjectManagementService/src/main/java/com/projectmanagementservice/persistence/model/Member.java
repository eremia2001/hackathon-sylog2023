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
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private MemberRole role = MemberRole.MEMBER;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;

    @OneToMany(mappedBy = "assignedMember", fetch = FetchType.LAZY)
    private Set<Task> assignedTasks;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private Set<Comment> writtenComments;
}
