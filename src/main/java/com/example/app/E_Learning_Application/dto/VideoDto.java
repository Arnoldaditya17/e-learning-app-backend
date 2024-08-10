package com.example.app.E_Learning_Application.dto;

import com.example.app.E_Learning_Application.entity.Course;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class VideoDto {
    private String id;

    private String title;

    private String description;

    private String filePath;

    private String contentType;

    private CourseDto course;
}
