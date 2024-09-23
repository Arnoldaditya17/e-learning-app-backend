package com.example.app.E_Learning_Application.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categories")
@Data
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private String description;

    private Date created_at;

    private String banner;

    @ManyToMany(mappedBy = "categoryList")
    private List<Course> courses = new ArrayList<>();

}
