package com.airlinebesties.documententity;

import com.airlinebesties.project.Project;
import jakarta.persistence.*;

@Entity
@Table(name = "document")
public class DocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] docBytes;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;
}
