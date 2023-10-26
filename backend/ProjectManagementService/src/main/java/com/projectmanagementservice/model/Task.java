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
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Date dueDate;

    @Column
    @Enumerated(EnumType.STRING)
    private TaskStatus status = TaskStatus.OPEN;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @OneToMany(mappedBy = "task")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "assigned_user_id")
    private User assignedUser;
}
