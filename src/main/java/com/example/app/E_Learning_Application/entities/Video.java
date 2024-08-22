package com.example.app.E_Learning_Application.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "videos")
public class Video {

    @Id
    private String id;

    private String title;

    private String description;

    private String filePath;

    private String contentType;

    @ManyToOne
    private Course course;
}
