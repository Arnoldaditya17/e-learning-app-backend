package com.example.app.E_Learning_Application.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryDto {


    private String id;

    private String title;

    private String description;

    private Date created_at;

}
