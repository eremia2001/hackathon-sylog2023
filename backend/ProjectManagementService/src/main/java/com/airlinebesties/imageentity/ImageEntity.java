package com.airlinebesties.imageentity;

import com.airlinebesties.project.Project;
import jakarta.persistence.*;

@Entity
@Table(name = "image")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private byte[] imageBytes;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

}
