package com.example.app.E_Learning_Application.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class VideoDto implements Serializable {
    private UUID id;

    private String title;

    private String description;

    private String filePath;

    private String contentType;

    private CourseDto course;
}
