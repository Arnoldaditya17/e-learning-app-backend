package com.example.app.E_Learning_Application.dto;

import com.example.app.E_Learning_Application.entity.Category;
import com.example.app.E_Learning_Application.entity.Video;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CourseDto {


    private String title;

    private String banner;

    private String shortDescription;

    private String longDescription;

    private double price;

    private boolean live=false;

    private double discount;

    private Date created_at;

    private Date updated_at;


    private List<VideoDto> videoList = new ArrayList<>();

    private List<CategoryDto> categoryList = new ArrayList<>();
}
