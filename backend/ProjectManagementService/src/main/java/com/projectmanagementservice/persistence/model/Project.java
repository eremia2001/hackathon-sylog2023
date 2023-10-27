package com.projectmanagementservice.persistence.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private int budget;

    @Column
    @Enumerated(EnumType.STRING)
    private ProjectStatus status = ProjectStatus.UPCOMING;

    @ManyToOne
    @JoinColumn(name = "org_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Organization organization;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Task> tasks = new HashSet<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Builder.Default
    private Set<ImageEntity> images = new HashSet<>();

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DocumentEntity> documents;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private Set<Resource> resources = new HashSet<>();
}
