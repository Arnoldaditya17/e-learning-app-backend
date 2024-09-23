package com.example.app.E_Learning_Application.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "courses")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private String banner;

    private String shortDescription;

    private String longDescription;

    private double price;

    private boolean live=false;

    private double discount;

    private Date created_at;

    private Date updated_at;

    @OneToMany(mappedBy = "course")
    private List<Video> videoList = new ArrayList<>();

    @ManyToMany
    private List<Category> categoryList = new ArrayList<>();
}
