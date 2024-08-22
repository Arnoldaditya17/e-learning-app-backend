package com.example.app.E_Learning_Application.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Category {

    @Id
    private String id;

    private String title;

    private String description;

    private Date created_at;

    @ManyToMany(mappedBy = "categoryList")
    private List<Course> courses = new ArrayList<>();

}
