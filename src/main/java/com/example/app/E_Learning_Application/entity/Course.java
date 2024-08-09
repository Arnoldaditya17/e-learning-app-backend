package com.example.app.E_Learning_Application.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "courses")
public class Course {

    @Id
    private String title;

    private String banner;

    private String shortDescription;

    private String longDescription;

    private Double price;

    private boolean live=false;

    private double discount;

    private Date created_at;

    private Date updated_at;

    @OneToMany(mappedBy = "course")
    private List<Video> videoList = new ArrayList<>();

    @ManyToMany
    private List<Category> categoryList = new ArrayList<>();
}
