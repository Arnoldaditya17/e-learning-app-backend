package com.example.app.E_Learning_Application.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class CourseDto implements Serializable {


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


//    private List<VideoDto> videoList = new ArrayList<>();

    private List<CategoryDto> categoryList = new ArrayList<>();
}
