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
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Date start;

    @Column
    private Date end;

    @Column
    private int budget;

    @Column
    @Enumerated(EnumType.STRING)
    private ProjectStatus status = ProjectStatus.UPCOMING;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Task> tasks;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<ImageEntity> images;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<DocumentEntity> documents;

    @OneToMany(mappedBy = "project")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Comment> comments;
}
