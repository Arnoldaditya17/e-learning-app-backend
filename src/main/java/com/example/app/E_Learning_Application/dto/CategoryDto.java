package com.example.app.E_Learning_Application.dto;

import com.example.app.E_Learning_Application.entity.Course;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CategoryDto {


    private String id;

    private String title;

    private String description;

    private Date created_at;

}
